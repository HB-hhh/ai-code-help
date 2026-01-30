package com.study.aicodehelp.controller;

import com.study.aicodehelp.ai.AiCodeHelperService;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.Disposable;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;

@RestController
@RequestMapping("/ai")
public class AiController {
    @Resource
    private AiCodeHelperService aiCodeHelperService;

    private static final long SSE_TIMEOUT_MS = 5 * 60 * 1000L; // 5 分钟
    /** 流结束标记：前端收到后关闭连接，避免 EventSource 自动重连导致同一问题被重复回答 */
    private static final String STREAM_END_MARKER = "[DONE]";

    @GetMapping(value = "chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter chat(@RequestParam int memoryId, @RequestParam String message) {
        SseEmitter emitter = new SseEmitter(SSE_TIMEOUT_MS);

        Disposable subscription = aiCodeHelperService.chatStream(memoryId, message)
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(
                        chunk -> {
                            try {
                                emitter.send(chunk, MediaType.TEXT_PLAIN);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        error -> {
                            try {
                                emitter.send(STREAM_END_MARKER, MediaType.TEXT_PLAIN);
                                emitter.completeWithError(error);
                            } catch (Exception ignored) {
                            }
                        },
                        () -> {
                            try {
                                emitter.send(STREAM_END_MARKER, MediaType.TEXT_PLAIN);
                                emitter.complete();
                            } catch (Exception ignored) {
                            }
                        }
                );

        emitter.onTimeout(() -> {
            subscription.dispose();
            try {
                emitter.send(STREAM_END_MARKER, MediaType.TEXT_PLAIN);
                emitter.complete();
            } catch (Exception ignored) {
            }
        });
        emitter.onCompletion(() -> subscription.dispose());
        emitter.onError(e -> subscription.dispose());

        return emitter;
    }
}
