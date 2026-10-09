package zhishoulife.common.core.domain.model;

import lombok.Data;

/**
 * AI响应模型（完整）
 */
@Data
public class ChatResponse {
    private Integer code = 200;  // 状态码：200成功/500失败
    private String sessionId;    // 会话ID
    private String message;      // AI回复内容
    private String errorMsg;     // 错误信息

    // 成功构造器
    public ChatResponse(String sessionId, String message) {
        this.sessionId = sessionId;
        this.message = message;
    }

    // 失败构造器
    public ChatResponse(Integer code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }
}