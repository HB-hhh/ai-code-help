package com.study.aicodehelp.ai.guardrail;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.guardrail.InputGuardrail;
import dev.langchain4j.guardrail.InputGuardrailResult;

import java.util.Set;

public class SafeInputGuardrail implements InputGuardrail {

    //敏感词集合
    private static final Set<String> sensitiveWords_ = Set.of("kill","evil");

    @Override
    public InputGuardrailResult validate(UserMessage userMessage) {
        //获取用户输入信息并转化为小写以确保大小写不敏感
        String content = userMessage.singleText().toLowerCase();
        //使用正则表达式分割文本输入为单词
        String[] words = content.split("\\W+");
        //遍历所有单词 检查是否存在敏感词
        for (String word : words) {
            if (sensitiveWords_.contains(word)) {
                //存在敏感词，返回拒绝输入结果
                return fatal("Input contains sensitive words: " + word);
            }
        }


        return success();
    }
}
