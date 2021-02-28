package com.holddie.jvm;

import org.apache.commons.lang3.StringUtils;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

/**
 * {@link ModuleClassLoader}
 *
 * @author HoldDie
 */
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
