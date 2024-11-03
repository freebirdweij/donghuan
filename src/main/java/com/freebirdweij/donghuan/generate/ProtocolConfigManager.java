package com.freebirdweij.donghuan.generate;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.util.ConcurrentReferenceHashMap;
/**
 * 配置管理器
 */
@Service
public class ProtocolConfigManager {

   private ConcurrentReferenceHashMap<String, DeviceProtocolConfig> configCache = new ConcurrentReferenceHashMap<String, DeviceProtocolConfig>();

    public void uploadConfig(String deviceType, MultipartFile excelFile) throws IOException {
        ExcelProtocolParser excelParser = new ExcelProtocolParser();
        // 解析Excel
        DeviceProtocolConfig config = excelParser.parseExcel(excelFile);
        DeviceCodeGenerator codeGenerator = new DeviceCodeGenerator();
        // 生成代码
        codeGenerator.generateCode(config);
        DynamicClassLoader dynamicLoader = new DynamicClassLoader();
        // 编译和加载
        dynamicLoader.loadGeneratedClasses();
        // 缓存配置
        configCache.put(deviceType, config);
    }

    public DeviceProtocolConfig getConfig(String deviceType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConfig'");
    }
}
