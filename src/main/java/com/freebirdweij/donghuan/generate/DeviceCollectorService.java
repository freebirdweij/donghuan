package com.freebirdweij.donghuan.generate;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 设备数据采集服务
 */
@Service
public class DeviceCollectorService {
    @Autowired
    private ProtocolConfigManager configManager;
    
    public void collectData(String deviceType, String deviceId) {
        DeviceProtocolConfig config = configManager.getConfig(deviceType);
        BaseProtocolHandler handler = createHandler(config);
        
        try {
            handler.connect();
            Map<String, Object> data = handler.read();
            // 处理采集到的数据
            processCollectedData(deviceId, data);
        } finally {
            handler.disconnect();
        }
    }

    private void processCollectedData(String deviceId, Map<String, Object> data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processCollectedData'");
    }

    private BaseProtocolHandler createHandler(DeviceProtocolConfig config) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createHandler'");
    }
}