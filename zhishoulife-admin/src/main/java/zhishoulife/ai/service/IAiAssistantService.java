package zhishoulife.ai.service;

import zhishoulife.common.core.domain.model.ChatRequest;
import zhishoulife.common.core.domain.model.ChatResponse;

/**
 * 智能助手核心业务接口（Java 8兼容版）
 */
public interface IAiAssistantService {
    // 处理用户问题（提示词优化+API调用+结果格式化）
    ChatResponse processQuestion(ChatRequest request);
}