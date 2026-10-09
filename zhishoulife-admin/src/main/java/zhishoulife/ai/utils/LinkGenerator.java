package zhishoulife.ai.utils;

import org.springframework.stereotype.Component;

/**
 * 链接生成工具（Java 8兼容版）
 */
@Component
public class LinkGenerator {
    /**
     * 生成页面链接（预留真实路径占位符）
     */
    public String generateLink(String type, String key) {
        switch (type) {
            case "big": // 大类页面
                return "/system/module/" + (key.isEmpty() ? "big-category" : key.replace(" ", "-").toLowerCase());
            case "small": // 小类页面
                return "/system/module/" + (key.isEmpty() ? "small-category" : key.replace(" ", "-").toLowerCase());
            case "detail": // 详情页
                return "/system/detail/" + (key.isEmpty() ? "0" : key);
            default:
                return "#";
        }
    }
}