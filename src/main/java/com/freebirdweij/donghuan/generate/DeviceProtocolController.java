package com.freebirdweij.donghuan.generate;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
/**
 * 使用示例
 */
@RestController
@RequestMapping("/api/device-protocol")
public class DeviceProtocolController {
    @Autowired
    private ProtocolConfigManager protocolConfigManager;
    
    @PostMapping("/upload")
    public ResponseEntity<?> uploadProtocolConfig(
            @RequestParam("deviceType") String deviceType,
            @RequestParam("file") MultipartFile file) throws IOException {
        protocolConfigManager.uploadConfig(deviceType, file);
        return ResponseEntity.ok().build();
    }
}
