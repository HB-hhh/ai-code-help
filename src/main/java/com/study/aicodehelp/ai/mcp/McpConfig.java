package com.study.aicodehelp.ai.mcp;

import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.transport.http.HttpMcpTransport;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {

    @Value("${bigmodel.api-key}")
    private String mcpApiKey;

    @Bean
    public McpToolProvider mcpToolProvider(){

        //通过http调用
        HttpMcpTransport transport = new HttpMcpTransport.Builder()
                .sseUrl("https://open.bigmodel.cn/api/mcp/web_search/sse?Authorization=" + mcpApiKey)
                .logRequests(true)
                .logResponses(true)
                .timeout(Duration.ofMinutes(5))
                .build();

        //创建Mcp客户端
        DefaultMcpClient mcpClient = new DefaultMcpClient.Builder()
                .key("wodekehuduan")
                .transport(transport)
                .build();

        //从MCP客户端获取工具
        McpToolProvider toolProvider = McpToolProvider.builder()
                .mcpClients(mcpClient)
                .build();

        return toolProvider;
    }
}
