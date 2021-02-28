## 1. 使用自定义Classloader机制，实现xlass的加载

### 1.1 类加载流程

#### BootStrap 加载路径

```java
System.getProperty("sun.boot.class.path")

输出结果如下：
xxx/jre/lib/resources.jar: 
xxx/jre/lib/rt.jar: 
xxx/jre/lib/sunrsasign.jar: 
xxx/jre/lib/jsse.jar: 
xxx/jre/lib/jce.jar: 
xxx/jre/lib/charsets.jar: 
xxx/jre/lib/jfr.jar: 
xxx/jre/classes
```

#### ExtClassLoader 加载路径

```java
System.getProperty("java.ext.dirs")

输出结果如下：
/Users/xxx/Library/Java/Extensions:
xxx/jre/lib/ext:
/Library/Java/Extensions:
/Network/Library/Java/Extensions:
/System/Library/Java/Extensions:
/usr/lib/java
```

#### AppClassLoader 加载路径

```java
System.out.println("自定义类加载路径：");
System.out.println(AXClassLoader.class.getClassLoader());
System.out.println("对应Parent ClassLoader：");
System.out.println(AXClassLoader.getSystemClassLoader().getParent());
// 虽然结果为null，但是我们知道此时应该为启动类
System.out.println("对应父类的父类 ClassLoader：");
System.out.println(AXClassLoader.getSystemClassLoader().getParent().getParent());
```

### 1.2 Java Resource 路径

```java
private static void printResourcePath() {
    System.out.println("AXClassLoader.class.getResource(\"\")):\n" + AXClassLoader.class.getResource(""));
    System.out.println("AXClassLoader.class.getResource(\"/\")):\n" + AXClassLoader.class.getResource("/"));
    System.out.println("AXClassLoader.class.getClassLoader().getResource(\"\")):\n" + AXClassLoader.class.getClassLoader().getResource(""));
    System.out.println("ClassLoader.getSystemResource(\"))\n" + ClassLoader.getSystemResource(""));
    System.out.println("Thread.currentThread().getContextClassLoader().getResource(\"\")\n" + Thread.currentThread().getContextClassLoader().getResource(""));
}

输出结果：
AXClassLoader.class.getResource("")):
file:/xxx/java-p7-in-action/jvm-base/target/classes/com/holddie/jvm/classloader/v1/

AXClassLoader.class.getResource("/")):
file:/xxx/java-p7-in-action/jvm-base/target/classes/

AXClassLoader.class.getClassLoader().getResource("")):
file:/xxx/java-p7-in-action/jvm-base/target/classes/

ClassLoader.getSystemResource("))
file:/xxx/java-p7-in-action/jvm-base/target/classes/

Thread.currentThread().getContextClassLoader().getResource("")
file:/xxx/java-p7-in-action/jvm-base/target/classes/
```

#### 1.3 实现 AXClassLoader 定义

```java
public class AXClassLoader extends ClassLoader {

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    try {
      byte[] bytes = Files.readAllBytes(Paths.get(getFileName(name)));
      // 由于 xlass 在生成的时候使用了特殊规则，所以在加载完之后，需要恢复回去
      for (int i = 0; i < bytes.length; i++) {
        bytes[i] = (byte) (255 - bytes[i]);
      }
      return defineClass(name, bytes, 0, bytes.length);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return super.findClass(name);
  }

  private String getFileName(String name) {
    int index = name.lastIndexOf('.');
    if (index == -1) {
      return ClassLoader.getSystemResource("").getPath() + name + ".xlass";
    } else {
      return ClassLoader.getSystemResource("").getPath() + name.substring(index + 1) + ".xlass";
    }
  }
}
```

#### 1.4 调用加载

```java
/*
 * 自定义加载器加载
 */
AXClassLoader axClassLoader = new AXClassLoader();
try {
    Class<?> hello = axClassLoader.loadClass("Hello");
    if (hello != null) {
        Object obj = hello.newInstance();
        Method method = hello.getDeclaredMethod("hello");
        method.invoke(obj);
    }
} catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
    e.printStackTrace();
}
```

## 2. 实现xlass打包的xar（类似class文件打包的jar）的加载

#### 2.1 生成 xar 包

```java
private static void createHelloXar() {
  try {
    XarSink xarSink = new XarSink();
    final XarFileSource fileSource;
    final File fileToCompress = getClasspathResourceAsFile(CLASS_FILE_NAME);
    assert fileToCompress != null;
    fileSource = new XarFileSource(fileToCompress);
    xarSink.addSource(fileSource);
    URL resource = Thread.currentThread().getContextClassLoader().getResource("");
    assert resource != null;
    xarSink.write(FileUtils.openOutputStream(new File(resource.getPath(), XAR_FILE_NAME)));
  } catch (Exception e) {
    e.printStackTrace();
  }
}
```

#### 2.2 解析 xar 包

```java
@Override
protected Class<?> findClass(String name) throws ClassNotFoundException {
  try {
    XarSource xar = new FileXarSource(getClasspathResourceAsFile(name));
    XarEntry entry = xar.getEntry(CLASS_FILE_NAME);
    byte[] bytes = entry.getBytes();
    // 由于 xlass 在生成的时候使用了特殊规则，所以在加载完之后，需要恢复回去
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) (255 - bytes[i]);
    }
    return defineClass(CLASS_NAME, bytes, 0, bytes.length);
  } catch (IOException | URISyntaxException e) {
    e.printStackTrace();
  }
  return super.findClass(name);
}
```

#### 2.3 加载 xar 包

```java
/*
 *自定义加载 xar 文件
 */
AXClassLoader axClassLoader = new AXClassLoader();
try {
  Class<?> hello = axClassLoader.loadClass(XAR_FILE_NAME);
  if (hello != null) {
    Object obj = hello.newInstance();
    Method method = hello.getDeclaredMethod(METHOD_NAME);
    method.invoke(obj);
  }
} catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
  e.printStackTrace();
}
```

## 3. 基于自定义Classloader实现类的动态加载和卸载

#### 3.1 理论支撑

如何实现类的卸载，需要满足哪些条件：

- 该类的所有实例对象不可达
- 该类的Class对象不可达
- 该类的ClassLoader不可达

使用什么方式监控JVM的加载和卸载过程？

- `-verbose:class` ：同时追踪类的加载和卸载
- `-XX:+TraceClassLoading`：单独跟踪类的加载
- `-XX:+TranceUnloading`：单独跟踪累的卸载

类加载器特征

- 每个ClassLoader都维护了一份自己的名称空间，同一个名称空间里不能出现两个同名的类；
- 为了实现Java安全沙箱模型的类加载安全机制，Java默认采用了“双亲委派的加载链”结构；

#### 3.2 动态加载

这里我们清楚，类的动态加载，或者说热加载，就是我们程序从一个固定路径读取 class 文件，同样类名称，前后修改方法实现，使用替换手法，就可以立即使用替换类的方法。

```java
public class AXClassLoader extends ClassLoader {
  /**
     * 基础包路径
     */
  private String basePackagePath;
  /**
     * 需要该类加载器直接加载的类文件的基目录
     */
  private String basedir;
  /**
     * 需要由该类加载器直接加载的类名
     */
  private HashSet<Object> dynaclazns;

  public AXClassLoader(String basedir, String[] clazns, String packagePath) {
    // 指定父类加载器为 null
    super(null);
    this.basePackagePath = packagePath;
    this.basedir = basedir;
    dynaclazns = new HashSet<>();
    loadClassByMe(clazns);
  }

  @SneakyThrows
  private void loadClassByMe(String[] clazns) {
    for (int i = 0; i < clazns.length; i++) {
      String fileNamePath = getFileName(clazns[i]);
      byte[] bytes = Files.readAllBytes(Paths.get(fileNamePath));
      defineClass(this.basePackagePath + "." + clazns[i], bytes, 0, bytes.length);
      dynaclazns.add(clazns[i]);
    }
  }

  private String getFileName(String name) {
    int index = name.lastIndexOf('.');
    if (index == -1) {
      return this.basedir + name + ".class";
    } else {
      return this.basedir + name.substring(index + 1) + ".class";
    }
  }

  @Override
  protected Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
    Class cls = findLoadedClass(name);
    if (!this.dynaclazns.contains(name) && cls == null) {
      cls = getSystemClassLoader().loadClass(name);
    }
    if (cls == null) {
      throw new ClassNotFoundException(name);
    }
    if (resolve) {
      resolveClass(cls);
    }
    return cls;
  }

  public static void main(String[] args) {
    String packagePath = "com.holddie.jvm.classloader.v3";
    new Timer("timer - 1")
      .schedule(
      new TimerTask() {
        @Override
        public void run() {
          try {
            // 每次都创建出一个新的类加载器
            AXClassLoader cl =
              new AXClassLoader(
              ClassLoader.getSystemResource("").getPath()
              + "v3/",
              new String[] {"Foo"},
              packagePath);
            Class cls = cl.loadClass(packagePath + ".Foo");
            Object foo = cls.newInstance();

            Method m = foo.getClass().getMethod("sayHello", new Class[] {});
            m.invoke(foo, new Object[] {});
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      },
      2000,
      3000);
  }
}

```

对应这里，我们使用 resources 文件夹下的 v3_2 的 Foo.class 文件替换之前文件夹下的 Foo.class 文件。注意我们为什么要使用一个 Schedule 定时加载，主要目的模拟程序在频繁类加载，方便前后两次热替换之后，方法输出结果展示；

#### 3.3 卸载

上述介绍了满足类卸载的三个条件，code show as flow:

```java
public static void main(String[] args) {
  String packagePath = "com.holddie.jvm.classloader.v3";
  new Timer("timer - 1")
    .schedule(
    new TimerTask() {
      @Override
      public void run() {
        try {
          // 每次都创建出一个新的类加载器
          AXClassLoader cl =
            new AXClassLoader(
            ClassLoader.getSystemResource("").getPath()
            + "v3/",
            new String[] {"Foo"},
            packagePath);
          Class cls = cl.loadClass(packagePath + ".Foo");
          Object foo = cls.newInstance();

          Method m = foo.getClass().getMethod("sayHello", new Class[] {});
          m.invoke(foo, new Object[] {});

          foo = null;
          cls = null;
          cl = null;
          System.gc();
          System.out.println("GC over");
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    },
    2000,
    3000);
}
```

此处注意我们，将对应的引用都置为空，之后手动执行了 `System.gc()` 方法，对此我们要观察类的加载和卸载需要在程序启动的时候设置JVM参数 `-verbose:class` 即可看到对应 loading 和 unloading 日志；

### 4. 基于自定义 Classloader 实现模块化机制：需要设计模块化机制。

主要思想：

- 已经熟悉基于一个类的加载和卸载，在实际使用原理上大同小异；
- 一个基础模块，提供抽象定义；
- 两个实现模块，每个模块内部都有自己 module.properties 文件定义自己模块版本、模块入口等，以作为生成jar包运行使用；
- 一个运行模块，使用两种模块化加载方式；

#### 4.1 multi-skd 基础模块

定义模块抽象方法

```java
public interface IFun {
  void sayHello(String name);
}
```

#### 4.2 multi-fz 实现模块

依赖基础模块，fz 自定义实现

```java
public class FzFun implements IFun {
  @Override
  public void sayHello(String name) {
    System.out.println("Hi " + name + ", i am FzFun");
  }
}
```

模块元数据声明 

```properties
# 位置在 resources/META-INF/module.properties 
module.appCode=fz
module.jarVersion=1.0
module.fun.location=com.holddie.jvm.FzFun
```

#### 4.3 multi-tz 实现模块

依赖基础模块，tz 自定义实现类

```java
public class TzFun implements IFun {
  @Override
  public void sayHello(String name) {
    System.out.println("Hi " + name + ", i am TzFun");
  }
}
```

模块元数据声明

```properties
# 位置在 resources/META-INF/module.properties 
module.appCode=tz
module.jarVersion=1.0
module.fun.location=com.holddie.jvm.TzFun
```

#### 4.4 multi-server 运行动态加载模块

使用两种方式，一种是JDK基于接口的动态代理，一种原生反射实现方法调用，详情在第五小节；

### 5. 使用 jar 作为模块，实现xar动态加载和卸载，综合应用前面的内容；

我们首先需要把实现模块的两个Jar包，打包OK，为下文加载提供方便，此处我们同时加载两个模块，并且指定了加载jar的名称，也可以使用自定义的目录区分；

#### 5.1 ModuleClassLoader

```java
public class ModuleClassLoader extends URLClassLoader {

  private final List<String> excludePackages;

  public ModuleClassLoader(URL[] urls, List<String> excludePackages) {
    super(urls);
    this.excludePackages = excludePackages;
  }

  @Override
  public Class<?> loadClass(String name) throws ClassNotFoundException {
    if (isExcludePackage(name)) {
      return super.loadClass(name);
    }
    synchronized (getClassLoadingLock(name)) {
      Class cls = findLoadedClass(name);
      if (cls == null) {
        try {
          cls = findClass(name);
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
      }
      if (cls != null) {
        return cls;
      }
    }
    return super.loadClass(name);
  }

  private boolean isExcludePackage(String name) {
    if (StringUtils.isEmpty(name)) {
      return false;
    }
    return this.excludePackages.stream().anyMatch(name::startsWith);
  }
}
```

#### 5.2 DynamicProxy

```java
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Long start = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        Long end = System.currentTimeMillis();
        String format = String.format("执行: class => %s, 方法=> %s, 参数 => %s, 耗时 => %sms, 执行结果 => %s, 当前路径 => %s",
                target.getClass().getName(),
                method.getName(),
                JSON.toJSON(args),
                end - start,
                JSON.toJSON(result),
                target.getClass().getResource("").getPath());
        System.out.println(format);
        return result;
    }
}
```

#### 5.3 ModuleJar

```java
public class ModuleJar {
    private String jarVersion;
    private String appCode;
    private String moduleJarUrl;
    private ModuleClassLoader moduleClassLoader;
    private String moduleFunLocation;

    public String getJarVersion() {
        return jarVersion;
    }

    public void setJarVersion(String jarVersion) {
        this.jarVersion = jarVersion;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getModuleJarUrl() {
        return moduleJarUrl;
    }

    public void setModuleJarUrl(String moduleJarUrl) {
        this.moduleJarUrl = moduleJarUrl;
    }

    public ModuleClassLoader getModuleClassLoader() {
        return moduleClassLoader;
    }

    public void setModuleClassLoader(ModuleClassLoader moduleClassLoader) {
        this.moduleClassLoader = moduleClassLoader;
    }

    public String getModuleFunLocation() {
        return moduleFunLocation;
    }

    public void setModuleFunLocation(String moduleFunLocation) {
        this.moduleFunLocation = moduleFunLocation;
    }
}
```

#### 5.4 MultiModuleLoaderMain

```java
public class MultiModuleLoaderMain {
  private final static String APP_CODE = "module.appCode";
  private final static String JAR_VERSION = "module.jarVersion";
  private final static String MODULE_FUN_LOCATION = "module.fun.location";

  public static void main(String[] args) {

    HashMap<String, ModuleJar> moduleCache = new HashMap<String, ModuleJar>();
    List<String> excludePackages = Arrays.asList("java", "com.holddie.jvm.sdk");
    List<String> jarUrls = Arrays.asList(
      "file:" + ClassLoader.getSystemResource("").getPath() + "multi-fz-1.0.0-jar-with-dependencies.jar",
      "file:" + ClassLoader.getSystemResource("").getPath() + "multi-tz-1.0.0-jar-with-dependencies.jar");
    jarUrls.forEach(url -> {
      try {
        URL moduleJarUrl = new URL(url);
        ModuleClassLoader moduleClassLoader = new ModuleClassLoader(new URL[]{moduleJarUrl}, excludePackages);
        Properties properties = getProperties(moduleClassLoader.getResourceAsStream("META-INF/module.properties"));
        ModuleJar moduleJar = new ModuleJar();
        moduleJar.setAppCode(properties.getProperty(APP_CODE));
        moduleJar.setJarVersion(properties.getProperty(JAR_VERSION));
        moduleJar.setModuleFunLocation(properties.getProperty(MODULE_FUN_LOCATION));
        moduleJar.setModuleClassLoader(moduleClassLoader);
        moduleJar.setModuleJarUrl(moduleJarUrl.getPath());
        moduleCache.put(moduleJar.getAppCode(), moduleJar);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    });

    ModuleJar fzModuleJar = moduleCache.get("fz");
    ModuleJar tzModuleJar = moduleCache.get("tz");

    try {
      ModuleClassLoader fzModuleJarModuleClassLoader = fzModuleJar.getModuleClassLoader();
      Object fzInstance = fzModuleJarModuleClassLoader.loadClass(fzModuleJar.getModuleFunLocation()).newInstance();
      Method fzSayHello = fzInstance.getClass().getMethod("sayHello", new Class[]{String.class});
      fzSayHello.invoke(fzInstance, new Object[]{"4456"});
      fzSayHello = null;
      fzInstance = null;
      fzModuleJarModuleClassLoader = null;
      fzModuleJar = null;
      moduleCache.put("fz", null);
      System.gc();

      IFun tzFun = (IFun) new DynamicProxy().bind(tzModuleJar.getModuleClassLoader().loadClass(tzModuleJar.getModuleFunLocation()).newInstance());
      tzFun.sayHello("123");
      tzFun.toString();
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
      e.printStackTrace();
    }
    System.out.println("----------------------");
    System.out.println();
  }

  public static Properties getProperties(InputStream inputStream) {
    Properties properties = new Properties();
    try {
      properties.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return properties;
  }
}
```

#### 5.6 运行日志

```java
[Opened /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.lang.Object from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.io.Serializable from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.lang.Comparable from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.lang.CharSequence from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.lang.String from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.lang.reflect.AnnotatedElement from 
[Loaded java.util.stream.Sink from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.util.stream.MatchOps$BooleanTerminalSink from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.util.function.Supplier from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.util.stream.MatchOps$$Lambda$3/511754216 from java.util.stream.MatchOps]
[Loaded java.util.stream.MatchOps$1MatchSink from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded com.holddie.jvm.sdk.IFun from file:/xxx/java-p7-in-action/jvm-base/modularization/multi-sdk/target/classes/]
[Loaded com.holddie.jvm.FzFun from file:/xxx/java-p7-in-action/jvm-base/modularization/multi-server/target/classes/multi-fz-1.0.0-jar-with-dependencies.jar]

Hi 4456, i am FzFun
 
[Unloading class com.holddie.jvm.FzFun 0x00000007c0086828]
[Loaded java.lang.reflect.InvocationHandler from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded com.holddie.jvm.DynamicProxy from file:/xxx/java-p7-in-action/jvm-base/modularization/multi-server/target/classes/]
[Loaded com.holddie.jvm.TzFun from file:/xxx/java-p7-in-action/jvm-base/modularization/multi-server/target/classes/multi-tz-1.0.0-jar-with-dependencies.jar]
[Loaded java.lang.reflect.Proxy from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.lang.reflect.WeakCache from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
.....
[Loaded java.lang.reflect.WeakCache$CacheValue from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.lang.reflect.UndeclaredThrowableException from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
 
Hi 123, i am TzFun

[Loaded com.alibaba.fastjson.JSONStreamAware from file:/Users/zeyangg/.m2/repository/com/alibaba/fastjson/1.2.4/fastjson-1.2.4.jar]
[Loaded com.alibaba.fastjson.JSONAware from file:/xxx/.m2/repository/com/alibaba/fastjson/1.2.4/fastjson-1.2.4.jar]
[Loaded java.util.HashMap$KeyIterator from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded com.alibaba.fastjson.serializer.ListSerializer from file:/Users/zeyangg/.m2/repository/com/alibaba/fastjson/1.2.4/fastjson-1.2.4.jar]
[Loaded com.alibaba.fastjson.serializer.SerialContext from file:/Users/zeyangg/.m2/repository/com/alibaba/fastjson/1.2.4/fastjson-1.2.4.jar]
执行: class => com.holddie.jvm.TzFun, 方法=> sayHello, 参数 => ["123"], 耗时 => 0ms, 执行结果 => null, 当前路径 => /xxx/java-p7-in-action/jvm-base/modularization/multi-server/target/classes/com/holddie/jvm/
执行: class => com.holddie.jvm.TzFun, 方法=> toString, 参数 => null, 耗时 => 0ms, 执行结果 => com.holddie.jvm.TzFun@6ed3ef1, 当前路径 => /xxx/java-p7-in-action/jvm-base/modularization/multi-server/target/classes/com/holddie/jvm/
----------------------

[Loaded sun.misc.VMSupport from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.util.Hashtable$KeySet from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded sun.nio.cs.ISO_8859_1$Encoder from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar]
```

注意，日志中的一些路径，自己做了一些脱敏使用 `/xxx` 代替，自己在看的时候，切勿当真以为是 `/xxx`，主要想表达的是一种数据脱敏；

## 参考链接

- [Class热替换与卸载](https://my.oschina.net/xianggao/blog/367822)
- [Tomcat热部署的实现原理](https://my.oschina.net/xianggao/blog/364068)
- [Java --ClassLoader创建、加载class、卸载class](https://www.cnblogs.com/eoss/p/5992499.html)
- [Java ClassLoader 技术剖析](https://developer.ibm.com/zh/articles/j-lo-hotswapcls/)
- [深入理解 ClassLoader](https://xie.infoq.cn/article/b1e7b584d48baa89379ab87e6)
- [带你从0到1撸一个简单版的模块化服务系统](https://juejin.cn/post/6844903925103984648)

