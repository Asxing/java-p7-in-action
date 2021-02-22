package com.holddie.jvm.classloader.v2;

import com.sprylab.xar.FileXarSource;
import com.sprylab.xar.XarEntry;
import com.sprylab.xar.XarSource;
import com.sprylab.xar.writer.XarFileSource;
import com.sprylab.xar.writer.XarSink;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;

public class AXClassLoader extends ClassLoader {

    private static final String CLASS_FILE_NAME = "Hello.xlass";
    private static final String XAR_FILE_NAME = "Hello.xar";
    private static final String CLASS_NAME = "Hello";
    private static final String METHOD_NAME = "hello";

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

    public static void main(String[] args) {
        // create Hello.xar
        createHelloXar();

        // load Hello.xar
        axloadHelloXar();
    }

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

    private static void axloadHelloXar() {
        /*
          自定义加载器加载
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
    }

    public static File getClasspathResourceAsFile(final String name) throws URISyntaxException {
        final URL resource = Thread.currentThread().getContextClassLoader().getResource(name);
        if (resource == null) {
            return null;
        }
        return new File(resource.toURI());
    }
}
