package com.springai.explore.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@Service
public class OpenAIChatService {
    private final ChatClient chatClient;

    public OpenAIChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }


    public String askToAI(String message,String username) {
        //, String username
        return chatClient
                .prompt(message)
                .advisors(advisorSpec -> advisorSpec.param(CONVERSATION_ID,username))
                .call()
                .content();
    }
    
}
