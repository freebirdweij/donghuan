package com.freebirdweij.donghuan.generate;

/**
 * 动态加载机制
 */
public class DynamicClassLoader extends ClassLoader {
    public Class<?> loadGeneratedClass(String className, byte[] classData) {
        return defineClass(className, classData, 0, classData.length);
    }

    public void loadGeneratedClasses() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadGeneratedClasses'");
    }
}
