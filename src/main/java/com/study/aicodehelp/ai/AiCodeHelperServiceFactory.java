package com.study.aicodehelp.ai;

import com.study.aicodehelp.ai.tools.DateTimeTool;
import com.study.aicodehelp.ai.tools.InterviewQuestionTool;
import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiCodeHelperServiceFactory {

    @Resource
    private ChatModel myQwenChatModel;

    @Resource
    private ContentRetriever contentRetriever;

    @Resource
    private McpToolProvider mcpToolProvider;

    @Resource
    private StreamingChatModel streamingChatModel;

    @Bean
    public AiCodeHelperService aiCodeHelperService(){
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        //构造aiMemory
        AiCodeHelperService aiCodeHelperService = AiServices.builder(AiCodeHelperService.class)
                .chatMemory(chatMemory)
                .chatModel(myQwenChatModel)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10)) //每个会话独立存储
                .streamingChatModel(streamingChatModel) // 流式输出
                .contentRetriever(contentRetriever) //Rag 知识库
                .tools(new InterviewQuestionTool(), new DateTimeTool()) // 工具：面试题搜索、当前日期时间
                .toolProvider(mcpToolProvider) // MCP工具
                .build();

        return aiCodeHelperService;
    }
}
