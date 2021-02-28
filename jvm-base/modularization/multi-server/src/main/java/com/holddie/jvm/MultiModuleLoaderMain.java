package com.holddie.jvm;

import com.holddie.jvm.sdk.IFun;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class MultiModuleLoaderMain {
    private static final String APP_CODE = "module.appCode";
    private static final String JAR_VERSION = "module.jarVersion";
    private static final String MODULE_FUN_LOCATION = "module.fun.location";

    public static void main(String[] args) {

        HashMap<String, ModuleJar> moduleCache = new HashMap<String, ModuleJar>();
        List<String> excludePackages = Arrays.asList("java", "com.holddie.jvm.sdk");
        List<String> jarUrls =
                Arrays.asList(
                        "file:"
                                + ClassLoader.getSystemResource("").getPath()
                                + "multi-fz-1.0.0-jar-with-dependencies.jar",
                        "file:"
                                + ClassLoader.getSystemResource("").getPath()
                                + "multi-tz-1.0.0-jar-with-dependencies.jar");
        jarUrls.forEach(
                url -> {
                    try {
                        URL moduleJarUrl = new URL(url);
                        ModuleClassLoader moduleClassLoader =
                                new ModuleClassLoader(new URL[] {moduleJarUrl}, excludePackages);
                        Properties properties =
                                getProperties(
                                        moduleClassLoader.getResourceAsStream(
                                                "META-INF/module.properties"));
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
            Object fzInstance =
                    fzModuleJarModuleClassLoader
                            .loadClass(fzModuleJar.getModuleFunLocation())
                            .newInstance();
            Method fzSayHello =
                    fzInstance.getClass().getMethod("sayHello", new Class[] {String.class});
            fzSayHello.invoke(fzInstance, new Object[] {"4456"});
            fzSayHello = null;
            fzInstance = null;
            fzModuleJarModuleClassLoader = null;
            fzModuleJar = null;
            moduleCache.put("fz", null);
            System.gc();

            IFun tzFun =
                    (IFun)
                            new DynamicProxy()
                                    .bind(
                                            tzModuleJar
                                                    .getModuleClassLoader()
                                                    .loadClass(tzModuleJar.getModuleFunLocation())
                                                    .newInstance());
            tzFun.sayHello("123");
            tzFun.toString();
        } catch (InstantiationException
                | IllegalAccessException
                | ClassNotFoundException
                | NoSuchMethodException
                | InvocationTargetException e) {
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
