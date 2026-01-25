package com.study.aicodehelp.ai;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiCodeHelperServiceFactory {

    @Resource
    private ChatModel qwenChatModel;

    @Resource
    private ContentRetriever contentRetriever;

    @Bean
    public AiCodeHelperService aiCodeHelperService(){
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        //构造aiMemory
        AiCodeHelperService aiCodeHelperService = AiServices.builder(AiCodeHelperService.class)
                .chatMemory(chatMemory)
                .chatModel(qwenChatModel)
                .contentRetriever(contentRetriever) //Rag 知识库
                .build();

        return aiCodeHelperService;
    }
}
