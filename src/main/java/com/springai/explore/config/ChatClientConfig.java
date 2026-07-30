package com.springai.explore.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChatClientConfig {



    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder,ChatMemory chatMemory){

        SimpleLoggerAdvisor loggerAdvisor=  new SimpleLoggerAdvisor();
        MessageChatMemoryAdvisor memoryAdvisor =  MessageChatMemoryAdvisor
              .builder(chatMemory)

                .build();

        return  chatClientBuilder
                .defaultAdvisors(List.of(loggerAdvisor,memoryAdvisor))
                .build();
    }
}
