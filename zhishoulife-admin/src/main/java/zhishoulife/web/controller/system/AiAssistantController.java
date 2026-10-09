package zhishoulife.web.controller.system;

import zhishoulife.ai.service.IAiAssistantService;
import zhishoulife.common.annotation.Log;
import zhishoulife.common.core.controller.BaseController;
import zhishoulife.common.core.domain.AjaxResult;
import zhishoulife.common.core.domain.model.ChatRequest;
import zhishoulife.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 智能助手控制器（适配Java 8 + 若依Vue）
 */
@RestController
@RequestMapping("/system/ai-assistant")
public class AiAssistantController extends BaseController {
    @Autowired
    private IAiAssistantService aiAssistantService;

    /**
     * HTTP聊天接口（支持非实时通信）
     */
//    @PreAuthorize("@ss.hasPermi('ai:assistant:query')")
    @Log(title = "智能助手-小智", businessType = BusinessType.QUERY)
    @PostMapping("/chat")
    public AjaxResult chat(@RequestBody ChatRequest request) {
        return AjaxResult.success(aiAssistantService.processQuestion(request));
    }
}