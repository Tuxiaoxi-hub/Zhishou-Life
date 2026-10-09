package zhishoulife.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置（包含AI接口+WebSocket）
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // 允许所有源
        config.addAllowedOriginPattern("*");
        // 允许所有请求头
        config.addAllowedHeader("*");
        // 允许所有请求方法
        config.addAllowedMethod("*");
        // 允许携带Cookie
        config.setAllowCredentials(true);
        
        // AI接口跨域
        source.registerCorsConfiguration("/system/ai-assistant/**", config);
        // WebSocket跨域
        source.registerCorsConfiguration("/ws/**", config);
        source.registerCorsConfiguration("/app/**", config);
        source.registerCorsConfiguration("/topic/**", config);
        // 若依原有跨域
        source.registerCorsConfiguration("/**", config);
        
        return new CorsFilter(source);
    }
}