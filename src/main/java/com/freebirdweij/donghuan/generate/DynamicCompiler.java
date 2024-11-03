package com.freebirdweij.donghuan.generate;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import javax.tools.JavaFileObject;
import java.util.Arrays;

/**
 * 动态编译和加载
 */
public class DynamicCompiler {
    public Class<?> compileAndLoad(String className, String sourceCode) throws ClassNotFoundException {
        // 使用JavaCompiler编译代码
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        JavaFileObject file = new JavaSourceFromString(className, sourceCode);
        
        // 编译
        compiler.getTask(null, null, null, null, null, 
            Arrays.asList(file)).call();
            
        // 加载编译后的类
        return Class.forName(className);
    }
}