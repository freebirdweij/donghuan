package com.freebirdweij.donghuan.generate;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.freebirdweij.donghuan.generate.protocol.ProtocolHandler;
/**
 * 协议处理器工厂
 */
@Service
public class ProtocolHandlerFactory {
    private Map<String, Class<?>> protocolHandlers = new ConcurrentHashMap<>();
    
    public void registerProtocol(File protocolDoc) {
        ProtocolDocumentParser documentParser = new ProtocolDocumentParser();
        // 解析协议文档
        ProtocolDefinition definition = documentParser.parseDocument(protocolDoc);
        
        ProtocolCodeGenerator codeGenerator = new ProtocolCodeGenerator();
        // 生成协议处理器代码
        Class<?> handlerClass = codeGenerator.generateProtocolHandler(definition);
        
        // 注册协议处理器
        protocolHandlers.put(definition.getName(), handlerClass);
    }
    
    @SuppressWarnings("deprecation")
    public ProtocolHandler createHandler(String protocolName) throws ProtocolNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> handlerClass = protocolHandlers.get(protocolName);
        if (handlerClass == null) {
            throw new ProtocolNotFoundException(protocolName);
        }
        return (ProtocolHandler) handlerClass.newInstance();
    }
}
