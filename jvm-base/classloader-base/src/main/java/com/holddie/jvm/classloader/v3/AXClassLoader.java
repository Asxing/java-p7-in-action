package com.holddie.jvm.classloader.v3;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

public class AXClassLoader extends ClassLoader {
    /** 基础包路径 */
    private String basePackagePath;
    /** 需要该类加载器直接加载的类文件的基目录 */
    private String basedir;
    /** 需要由该类加载器直接加载的类名 */
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
}
