package com.freebirdweij.donghuan.generate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 使用示例
 */
@RestController
@RequestMapping("/api/protocol")
public class ProtocolController {
    @Autowired
    private ProtocolHandlerFactory protocolFactory;
    
    @PostMapping("/upload")
    public ResponseEntity<?> uploadProtocol(@RequestParam("file") MultipartFile file) {
        // 保存文件
        File protocolDoc = saveFile(file);
        
        // 注册协议
        protocolFactory.registerProtocol(protocolDoc);
        
        return ResponseEntity.ok().build();
    }

    private File saveFile(MultipartFile file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveFile'");
    }
}