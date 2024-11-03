package com.freebirdweij.donghuan.llm;

import com.freebirdweij.donghuan.generate.CommandDefinition;
import com.freebirdweij.donghuan.generate.ProtocolDefinition;

/**
 * 协议解析结果验证
 */
public class ProtocolValidator {
    public void validate(ProtocolDefinition protocol) {
        // 验证LLM解析结果的合理性
        validateBasicInfo(protocol);
        validateCommands(protocol.getCommands());
        validateDataFields(protocol);
        
        // 如果发现问题，可以再次请求LLM澄清
        if (needsClarification()) {
            requestClarification();
        }
    }
    
    private boolean needsClarification() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'needsClarification'");
    }

    private void validateDataFields(ProtocolDefinition protocol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateDataFields'");
    }

    private void validateBasicInfo(ProtocolDefinition protocol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateBasicInfo'");
    }

    private void validateCommands(CommandDefinition[] commands) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateCommands'");
    }

    private void requestClarification() {
        String clarificationPrompt = """
            发现以下问题需要澄清：
            1. %s
            2. %s
            请提供更详细的说明
            """;
        // 再次调用LLM
    }
}