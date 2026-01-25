package com.study.aicodehelp.ai;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AiCodeHelper {

    private static final String SYSTEM_PROMPT = """
            你是一个编程领域的小助手，帮助用户解答编程学习和求职面试相关的问题，并给出建议，重点关注四个方向：
            1. 规划清晰的编程学习路线
            2. 提供项目学习建议
            3. 给出程序员求职全流程指南（比如简历优化、投递技巧）
            4. 分享高频面试题和面试技巧
            请用简洁的语言回答，助力用户高效学习与求职
            """;

    @Resource
    private ChatModel qwenChatModel;

    //简单对话 文本
    public String chat(String message) {
        UserMessage userMessage = UserMessage.from(message);

        SystemMessage systemMessage = SystemMessage.from(SYSTEM_PROMPT);
        ChatResponse chatResponse = qwenChatModel.chat(systemMessage,userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        log.info("AI 输出内容：" + aiMessage.text());
        return aiMessage.text();
    }

    public String chat(UserMessage userMessage) {
        ChatResponse chatResponse = qwenChatModel.chat(userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        log.info("AI 输出内容：" + aiMessage.text());
        return aiMessage.text();
    }
}
