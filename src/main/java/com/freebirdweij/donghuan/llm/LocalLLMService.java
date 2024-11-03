package com.freebirdweij.donghuan.llm;

import org.springframework.stereotype.Service;


@Service
public class LocalLLMService implements LLMService {
    private final LLMClient llmClient = new LLMClient();
    
    @Override
    public String process(String prompt) {
        // 调用本地部署的开源LLM
        return llmClient.chat(prompt);
    }
}
