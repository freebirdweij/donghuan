package com.freebirdweij.donghuan.llm;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.freebirdweij.donghuan.generate.ProtocolDefinition;

/**
 * 使用示例
 * 
 */
@RestController
@RequestMapping("/api/protocol")
public class ProtocolController {
    @Autowired
    private LLMProtocolProcessor protocolProcessor;
    @Autowired
    private ProtocolValidator validator;
    @Autowired
    private InteractiveProtocolConfirmation confirmation;
    
    @PostMapping("/upload")
    public ResponseEntity<?> uploadProtocol(@RequestParam("file") MultipartFile file) throws IOException {
        // 处理协议文档
        ProtocolDefinition protocol = protocolProcessor.processDocument(file.getResource().getFile());
        // 验证结果
        validator.validate(protocol);
        
        // 用户确认
        protocol = confirmation.confirmWithUser(protocol);
        // 生成协议处理器
        generateProtocolHandler(protocol);
        
        return ResponseEntity.ok(protocol);
    }

    private void generateProtocolHandler(ProtocolDefinition protocol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateProtocolHandler'");
    }
}