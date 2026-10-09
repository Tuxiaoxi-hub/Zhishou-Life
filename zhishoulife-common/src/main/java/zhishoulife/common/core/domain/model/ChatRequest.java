package zhishoulife.common.core.domain.model;

import lombok.Data;
import java.util.List;

/**
 * AI请求模型（完整）
 */
@Data
public class ChatRequest {
    private String sessionId;    // 会话ID（上下文隔离）
    private String message;      // 用户输入消息
    private List<Message1> history; // 对话历史
    private Integer userId;      // 若依用户ID
}