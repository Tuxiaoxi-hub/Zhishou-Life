package zhishoulife.ai.service;

import zhishoulife.common.core.domain.model.ChatRequest;
import zhishoulife.common.core.domain.model.ChatResponse;
import zhishoulife.common.core.domain.model.Message1;
import java.util.List;

/**
 * DeepSeek API服务接口（Java 8兼容版）
 */
public interface ChatService {
    // 发送消息获取AI回复
    ChatResponse sendMessage(ChatRequest request);
    // 获取对话历史
    List<Message1> getConversationHistory(String sessionId);
    // 重置对话
    void resetConversation(String sessionId);
}