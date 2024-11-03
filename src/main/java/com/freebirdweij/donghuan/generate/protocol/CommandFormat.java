package com.freebirdweij.donghuan.generate.protocol;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field;

/**
 * 命令格式定义
 */
public class CommandFormat {
    private String commandType;  // 命令类型
    private String format;       // 命令格式
    private List<String> fields;  // 字段定义
    public Field[] getFields() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFields'");
    }
}