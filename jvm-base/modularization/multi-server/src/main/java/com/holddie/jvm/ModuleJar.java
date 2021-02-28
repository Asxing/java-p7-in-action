package com.holddie.jvm;

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
