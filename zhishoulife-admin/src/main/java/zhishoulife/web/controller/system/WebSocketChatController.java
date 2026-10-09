package zhishoulife.web.controller.system;

import zhishoulife.ai.service.IAiAssistantService;
import zhishoulife.common.core.domain.model.ChatRequest;
import zhishoulife.common.core.domain.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.UUID;

/**
 * WebSocket实时聊天控制器（Java 8兼容版）
 */
@Controller
public class WebSocketChatController {
    @Autowired
    private IAiAssistantService aiAssistantService;

    /**
     * 实时聊天接口：前端发送/app/ai-chat，广播到/topic/ai-messages
     */
    @MessageMapping("/ai-chat")
    @SendTo("/topic/ai-messages")
    public ChatResponse handleWebSocketMessage(ChatRequest request) {
        // 补全会话ID
        if (request.getSessionId() == null) {
            request.setSessionId(UUID.randomUUID().toString());
        }
        // 补全历史记录
        if (request.getHistory() == null) {
            request.setHistory(new ArrayList<>());
        }
        // 调用核心服务
        return aiAssistantService.processQuestion(request);
    }
}