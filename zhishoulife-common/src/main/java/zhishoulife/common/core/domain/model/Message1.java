package zhishoulife.common.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 对话消息模型（完整）
 */
@Data
@AllArgsConstructor
public class Message1 {
    private String role;    // 角色：user/assistant
    private String content; // 消息内容
}