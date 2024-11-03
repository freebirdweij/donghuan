package com.freebirdweij.donghuan.generate.protocol;

import java.util.List;
import java.util.Map;

/**
 * 协议配置模型
 */
public class ProtocolConfig {
    private String protocolType;  // 协议类型
    private String version;       // 协议版本
    private Map<String, String> parameters;  // 协议参数
    
    // 命令格式定义
    private List<CommandFormat> commandFormats;
    // 数据解析规则
    private List<DataParseRule> parseRules;
    public List<DataParseRule> getParseRules() {
        return parseRules;
    }
    public Object getProtocolType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProtocolType'");
    }
}