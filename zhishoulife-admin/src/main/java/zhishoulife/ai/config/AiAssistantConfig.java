package zhishoulife.ai.config;

import org.springframework.context.annotation.Configuration;
import java.util.HashSet;
import java.util.Set;

/**
 * 智能助手配置：表权限（完整36张表）
 */
@Configuration
public class AiAssistantConfig {
    public static final Set<String> ALLOWED_TABLES = new HashSet<String>() {{
        // 一、日常生活
        add("life_food_select");add("life_food_cook");add("life_food_taboo");
        add("life_clothes_clean");add("life_clothes_stain");add("life_clothes_storage");
        add("life_consumption_channel");add("life_consumption_dispute");
        // 二、健康医疗
        add("health_basic_nursing");add("health_season_health");add("health_sport_fitness");
        add("health_drug_safety");add("health_medical_process");add("health_checkup");
        add("health_first_aid");add("health_trauma_treat");
        // 三、安全防护
        add("safety_food_identify");add("safety_food_storage");add("safety_food_takeaway");
        add("safety_network_fraud");add("safety_network_privacy");add("safety_network_account");
        add("safety_home_fire_electric");add("safety_home_anti_theft");
        // 四、出行交通
        add("traffic_sign_identify");add("traffic_rule_common");add("traffic_public_safe");
        add("traffic_drive_safe");
        // 五、学习成长
        add("study_certificate_profession");add("study_certificate_language");
        add("study_skill_office");add("study_skill_life");
        // 六、居家实用
        add("home_storage_space");add("home_storage_goods");add("home_appliance_use");
        add("home_appliance_maintain");
    }};

    public static final String AI_NAME = "小智";
}