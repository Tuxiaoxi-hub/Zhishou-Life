package zhishoulife.ai.service.impl;

import com.google.gson.Gson;
import zhishoulife.ai.service.ChatService;
import zhishoulife.common.core.domain.model.ChatRequest;
import zhishoulife.common.core.domain.model.ChatResponse;
import zhishoulife.common.core.domain.model.Message1;
import okhttp3.*;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * DeepSeek API实现（适配Java 8 + OkHttp 3.14.9）
 */
@Service
public class ChatServiceImpl implements ChatService {
    // 你的DeepSeek API配置（已填好）
    private static final String API_KEY = "e3e01070-b243-4006-a53e-b465bf42b3ce";
    private static final String API_URL = "https://ark.cn-beijing.volces.com/api/v3/chat/completions";
    private static final String MODEL = "deepseek-v3-250324";

    private final OkHttpClient client;
    private final Gson gson;
    private final Map<String, List<Message1>> conversationStore;

    public ChatServiceImpl() {
        // 初始化OkHttp客户端（适配Java 8 + 3.14.9）
        this.client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(80, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
        this.gson = new Gson();
        this.conversationStore = new ConcurrentHashMap<>();
    }

    @Override
    public ChatResponse sendMessage(ChatRequest request) {
        String sessionId = request.getSessionId();
        if (sessionId == null || sessionId.isEmpty()) {
            sessionId = UUID.randomUUID().toString();
        }
        List<Message1> conversation = getOrCreateConversation(sessionId, request.getHistory());
        conversation.add(new Message1("user", request.getMessage()));

        try {
            String aiResponse = callDeepSeekApi(conversation);
            conversation.add(new Message1("assistant", aiResponse));
            return new ChatResponse(sessionId, aiResponse);
        } catch (IOException e) {
            return new ChatResponse(500, "API调用失败: " + e.getMessage());
        }
    }

    @Override
    public List<Message1> getConversationHistory(String sessionId) {
        return conversationStore.getOrDefault(sessionId, new ArrayList<>());
    }

    @Override
    public void resetConversation(String sessionId) {
        conversationStore.remove(sessionId);
    }

    private List<Message1> getOrCreateConversation(String sessionId, List<Message1> initialHistory) {
        return conversationStore.computeIfAbsent(sessionId, k ->
                initialHistory != null ? new ArrayList<>(initialHistory) : new ArrayList<>());
    }

    // 适配OkHttp 3.14.9的完整实现（核心修正：RequestBody参数顺序）
    private String callDeepSeekApi(List<Message1> conversation) throws IOException {
        Map<String, Object> requestData = new HashMap<>();
        requestData.put("model", MODEL);
        requestData.put("messages", conversation);
        requestData.put("temperature", 0.7);
        requestData.put("max_tokens", 1000);

        // 核心修正：OkHttp 3.14.9 正确的RequestBody创建方式（MediaType在前，数据在后）
        String jsonData = gson.toJson(requestData);
        MediaType jsonMediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody body = RequestBody.create(jsonMediaType, jsonData);

        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                String errorBody = response.body() != null ? response.body().string() : "";
                throw new IOException("API请求失败，状态码: " + response.code() + ", 错误信息: " + errorBody);
            }
            assert response.body() != null;
            Map<String, Object> responseMap = gson.fromJson(response.body().string(), new HashMap<String, Object>().getClass());
            List<Map<String, Object>> choices = (List<Map<String, Object>>) responseMap.get("choices");
            Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
            return (String) message.get("content");
        }
    }
}