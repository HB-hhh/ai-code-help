package com.study.aicodehelp.ai;

import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestEngine;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiCodeHelperTest {




    @Resource
    private AiCodeHelper aiCodeHelper;

    @Test
    public void chat01(){
        String string = aiCodeHelper.chat("你好，我是一名后端程序员");
    }

    @Test
    public void test02(){
        UserMessage userMessage = UserMessage.from(
                TextContent.from("描述图片"),
                ImageContent.from("C://Users//15443//Desktop//图片//4c5ecd17e3af16a436d970a4c9d12f43.jpg")
        );

        aiCodeHelper.chat(userMessage);
    }
}
