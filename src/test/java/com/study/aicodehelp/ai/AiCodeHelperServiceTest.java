package com.study.aicodehelp.ai;

import dev.langchain4j.service.Result;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AiCodeHelperServiceTest {

    @Resource
    private AiCodeHelperService aiCodeHelperService;

    @Test
    void chat() {
        String string = aiCodeHelperService.chat("你好，我是刚入行的菜鸟程序员");
        System.out.println(string);
    }

    @Test
    void chat02() {
        String string = aiCodeHelperService.chat("你好，我是小智，刚入行的菜鸟程序员");
        System.out.println(string);
        string = aiCodeHelperService.chat("我是谁来着？");
        System.out.println(string);
    }

    @Test
    void chatForReport() {
        String userMessage  = "你好，我是程序员小猪，请帮我制定学习报告";
        AiCodeHelperService.Report report = aiCodeHelperService.chatForReport(userMessage);


        System.out.println(report);
        System.out.println(report.name());
        System.out.println(report.suggestionList());
    }

    @Test
    void testWithRag(){
        String string = aiCodeHelperService.chat("你好，我是一个程序员，我想学习如何使用Rag进行开发，请给我一些建议");
        System.out.println(string);
    }

    @Test
    void testWithRag02(){
        Result<String> string = aiCodeHelperService.chatWithRag("怎么学习Java，有哪些面试题？");
        System.out.println(string.sources());
        System.out.println(string.content());
    }

    @Test
    void testWithTools(){
        String string = aiCodeHelperService.chat("有哪些常见的计算机网络面试题？");
        System.out.println(string);
    }


    @Test
    void testWithMcp(){
        String string = aiCodeHelperService.chat("什么是程序员鱼皮的编程导航？");
        System.out.println(string);
    }

    @Test
    void testWithGuardrail(){
        String string = aiCodeHelperService.chat("kill the game");
        System.out.println(string);
    }
}