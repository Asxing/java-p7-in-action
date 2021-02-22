package com.holddie.jvm.classloader.v1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public static void main(String[] args) {
        printClassLoader();

        printResourcePath();

        axloadClass();
    }

    private static void axloadClass() {
        /*
          自定义加载器加载
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
    }

    private static void printResourcePath() {
        System.out.println("AXClassLoader.class.getResource(\"\")):\n" + AXClassLoader.class.getResource(""));
        System.out.println("AXClassLoader.class.getResource(\"/\")):\n" + AXClassLoader.class.getResource("/"));
        System.out.println("AXClassLoader.class.getClassLoader().getResource(\"\")):\n" + AXClassLoader.class.getClassLoader().getResource(""));
        System.out.println("ClassLoader.getSystemResource(\"))\n" + ClassLoader.getSystemResource(""));
        System.out.println("Thread.currentThread().getContextClassLoader().getResource(\"\")\n" + Thread.currentThread().getContextClassLoader().getResource(""));
    }

    private static void printClassLoader() {
    /*
      查看启动类加载器
     
      xxx/jre/lib/resources.jar: 
      xxx/jre/lib/rt.jar: 
      xxx/jre/lib/sunrsasign.jar: 
      xxx/jre/lib/jsse.jar: 
      xxx/jre/lib/jce.jar: 
      xxx/jre/lib/charsets.jar: 
      xxx/jre/lib/jfr.jar: 
      xxx/jre/classes
     */
        System.out.println("BootStrap类加载器加载路径：");
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("----------------------------------------");

        /*
          查看扩展类加载器
         
          /Users/zeyangg/Library/Java/Extensions:
          xxx/jre/lib/ext:
          /Library/Java/Extensions:
          /Network/Library/Java/Extensions:
          /System/Library/Java/Extensions:
          j/usr/lib/java
         */
        System.out.println("ExtClassloader 加载路径");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("----------------------------------------");

        /*
          查看应用类加载器
         
          sun.misc.Launcher$AppClassLoader@18b4aac2
         */
        System.out.println("自定义类加载路径：");
        System.out.println(AXClassLoader.class.getClassLoader());
        System.out.println("对应Parent ClassLoader：");
        System.out.println(AXClassLoader.getSystemClassLoader().getParent());
        // 虽然结果为null，但是我们知道此时应该为启动类
        System.out.println("对应父类的父类 ClassLoader：");
        System.out.println(AXClassLoader.getSystemClassLoader().getParent().getParent());
        System.out.println("----------------------------------------");
    }
}
