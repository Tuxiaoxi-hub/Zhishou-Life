<template>
  <div class="chat-container">
    <div class="chat-header">
      <div class="header-inner">
        <div class="robot-icon-wrap">
          <img
            class="robot-avatar-img"
            :src="aiAvatarUrl"
            alt="小智头像"
            @error="resetAiAvatar"
          >
        </div>
        <span class="title-text">智能助手小智</span>
      </div>
    </div>

    <div class="chat-content" ref="contentRef">
      <div class="message-item ai-item">
        <div class="avatar ai-avatar">
          <img :src="aiAvatarUrl" alt="小智" @error="resetAiAvatar">
        </div>
        <div class="message-bubble ai-bubble">
          你好呀！我是生活知识小助手，能帮你查询这些实用信息，都是超实用的生活干货哦～<br/><br/>
          ✅ 日常生活相关：<br/>
          - 饮食美食（食材挑选保存、家常菜烹饪、饮食禁忌搭配）<br/>
          - 衣物护理（清洗保养、污渍去除、收纳整理）<br/>
          - 消费维权（维权渠道、常见纠纷处理）<br/><br/>
          ✅ 健康医疗相关：<br/>
          - 基础健康（常见病症护理、四季养生、运动健身常识）<br/>
          - 医疗常识（药物安全、就医流程、体检知识科普）<br/>
          - 急救护理（常见急救方法、外伤应急处理）<br/><br/>
          ✅ 安全防护相关：<br/>
          - 食品安全（食品辨别、储存安全、外卖安全）<br/>
          - 网络安全（诈骗防范、隐私保护、账号安全）<br/>
          - 居家安全（用火用电安全、防盗防入侵）<br/><br/>
          ✅ 出行交通相关：<br/>
          - 交通规则常识（交通标志识别、通行规则）<br/>
          - 出行安全（公共出行安全、自驾出行安全）<br/><br/>
          ✅ 学习成长相关：<br/>
          - 考证考级（职业资格证书、语言类证书）<br/>
          - 实用技能学习（办公软件技能、生活实用技能）<br/><br/>
          ✅ 居家实用相关：<br/>
          - 家居收纳（空间收纳技巧、物品收纳整理）<br/>
          - 家电使用（家电操作技巧、家电保养维护）<br/><br/>
          直接说你想查的内容就行，比如“番茄炒蛋做法”“羊毛衫防缩水”“网络诈骗防范”～
        </div>
      </div>

      <!-- 垂直快捷提问条（独立、美观、不占气泡） -->
      <div class="quick-group" style="padding-left: 46px;">
        <div class="quick-item" @click="quickSend('我想知道番茄炒蛋的做法')">
          我想知道番茄炒蛋的做法
        </div>
        <div class="quick-item" @click="quickSend('网络诈骗怎么防范')">
          网络诈骗怎么防范
        </div>
        <div class="quick-item" @click="quickSend('家电如何保养维护')">
          家电如何保养维护
        </div>
      </div>

      <div v-for="(item, idx) in messageList" :key="idx" class="message-item"
           :class="item.type === 'ai' ? 'ai-item' : 'user-item'">
        <template v-if="item.type === 'ai'">
          <div class="avatar ai-avatar">
            <img :src="aiAvatarUrl" alt="AI" @error="resetAiAvatar">
          </div>
          <div class="message-bubble ai-bubble">{{ item.content }}</div>
        </template>
        <template v-if="item.type === 'user'">
          <div class="message-bubble user-bubble">{{ item.content }}</div>
          <div class="avatar user-avatar">
            <img :src="userAvatar" alt="用户" @error="handleAvatarError">
          </div>
        </template>
      </div>
    </div>

    <div class="chat-input-area">
      <div class="input-inner">
        <el-input
          v-model="inputContent"
          type="textarea"
          rows="2"
          placeholder="请输入问题，按回车发送..."
          class="input-box"
          @keydown.enter.exact.prevent="sendMessage"
        ></el-input>
        <el-button
          type="default"
          class="action-btn voice-btn"
          @click="startVoiceRecord"
        >语音</el-button>
        <el-button
          type="primary"
          class="action-btn send-btn"
          @click="sendMessage"
          :disabled="!inputContent.trim()"
        >发送</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import request from '@/utils/request'

export default {
  name: "AiChat",
  data() {
    return {
      inputContent: '',
      messageList: [],
      sessionId: '',
      aiAvatarUrl: 'https://preview.qiantucdn.com/58pic/DB/6V/Iz/WF/9hep3bj1ladc45iuvyzsn2r06xkfgtom_PIC2018.png!qt_w320_webp'
    }
  },
  computed: {
    userInfo() {
      try {
        return JSON.parse(localStorage.getItem('userInfo') || '{}')
      } catch (e) {
        return {}
      }
    },
    userId() {
      return this.userInfo.userId || this.userInfo.id || '1'
    },
    userAvatar() {
      return 'https://ts2.tc.mm.bing.net/th/id/OIP-C.jHUH4s7TQ48X_B-1iozuJgHaHa?rs=1&pid=ImgDetMain&o=7&rm=3'
    }
  },
  mounted() {
    this.sessionId = Math.random().toString(36).slice(2, 10)
    this.$nextTick(() => this.scrollToBottom())
  },
  methods: {
    // 快捷提问
    quickSend(text) {
      this.inputContent = text
      this.sendMessage()
    },
    resetAiAvatar() {
      this.aiAvatarUrl = 'data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAxMDI0IDEwMjQiPgogIDxwYXRoIGQ9Ik01MTIgNjRDMjY0LjYgNjQgNjQgMjY0LjYgNjQgNTEyczIwMC42IDQ0OCA0NDggNDQ4IDQ0OC0yMDAuNiA0NDgtNDQ4Uzc1OS40IDY0IDUxMiA2NHptMCA4MjBjLTIwNS40IDAtMzcyLTE2Ni42LTM3Mi0zNzJzMTY2LjYtMzcyIDM3Mi0zNzIgMzcyIDE2Ni42IDM3MiAzNzItMTY2LjYgMzcyLTM3MiAzNzJ6IiBmaWxsPSIjNDA5ZWZmIi8+CiAgPHBhdGggZD0iTTczMi4yIDQxNy43TDY4OCAzNDIuN2MtMy42LTYtMTAtOS43LTE3LTkuN0g1NjhjLTQuNCAwLTggMy42LTggOHY2OC45YzAgMi4yIDEuMiA0LjIgMyA1LjNMNjY0IDU0NS42YzEwLjEgNiAxNSAxOC4zIDExLjkgMzAuMmwtMjQgODguMmMtMi40IDguOC0xMC40IDE1LjEtMTkuNSAxNS4xSDU0My4zYy00LjQgMC04IDMuNi04IDh2MzJjMCA0LjQgMy42IDggOCA4SDY2NGMxMy4yIDAgMjQtMTAuOCAyNC0yNFY2MDBjMC0xLjUtLjEtMy0uNC00LjVsMjQtODguMmM4LjMtMzAuNC0xMy43LTYwLjctNDQuMi02MC43SDYwMC43ek00OTIgNDk2Yy00LjQgMC04IDMuNi04IDh2MTkyYzAgNC40IDMuNiA4IDggOGg0MGM0LjQgMCA4LTMuNiA4LThWNTA0YzAtNC40LTMuNi04LTgtOGgtNDB6TTQxMiA1ODRjLTQuNCAwLTggMy42LTggOHYxMTJjMCA0LjQgMy42IDggOCA4aDQwYzQuNCAwIDgtMy42IDgtOFY1ODRjMC00LjQtMy42LTgtOC04aC00MHoiIGZpbGw9IiM0MDllZmYiLz4KPC9zdmc+'
    },
    handleAvatarError(e) {
      e.target.src = 'https://img1.baidu.com/it/u=865349952,2592566511&fm=253&fmt=auto&app=138&f=JPEG?w=100&h=100'
    },
    startVoiceRecord() {
      const Recog = window.SpeechRecognition || window.webkitSpeechRecognition
      if (!Recog) {
        this.$message.warning('当前浏览器不支持语音输入')
        return
      }
      const recog = new Recog()
      recog.lang = 'zh-CN'
      recog.interimResults = false
      recog.onstart = () => this.$message.info('🎤 正在聆听...')
      recog.onresult = (ev) => {
        this.inputContent = ev.results[0][0].transcript
        this.$message.success('识别完成')
      }
      recog.onerror = (err) => this.$message.error('语音失败：' + err.error)
      recog.start()
    },
    async sendMessage() {
      const content = this.inputContent.trim()
      if (!content) return

      this.messageList.push({ type: 'user', content })
      this.inputContent = ''
      await this.$nextTick(() => this.scrollToBottom())

      try {
        const res = await request({
          url: '/system/ai-assistant/chat',
          method: 'post',
          data: {
            sessionId: this.sessionId,
            message: content,
            userId: this.userId,
            history: []
          }
        })
        const aiContent = res.data?.message || res.data || '收到'
        this.messageList.push({ type: 'ai', content: aiContent })
      } catch (err) {
        console.error(err)
        this.$message.error('发送失败')
        this.messageList.push({ type: 'ai', content: '服务异常' })
      }
      await this.$nextTick(() => this.scrollToBottom())
    },
    scrollToBottom() {
      if (this.$refs.contentRef) {
        this.$refs.contentRef.scrollTop = this.$refs.contentRef.scrollHeight
      }
    }
  }
}
</script>

<style scoped>
.chat-container {
  width: 100%;
  height: calc(100vh - 84px);
  display: flex;
  flex-direction: column;
  background: #f7f9fc;
  overflow: hidden;
  font-size: 14px;
  box-sizing: border-box;
}
.chat-header {
  height: 56px;
  background: #fff;
  border-bottom: 1px solid #eaeef5;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0 20px;
  flex-shrink: 0;
}
.header-inner {
  display: flex;
  align-items: center;
  gap: 12px;
}
.robot-icon-wrap {
  width: 34px;
  height: 34px;
  border-radius: 50%;
  overflow: hidden;
}
.robot-avatar-img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
.title-text {
  font-size: 16px;
  font-weight: 500;
  color: #2f3439;
}
.chat-content {
  flex: 1;
  padding: 20px;
  overflow-y: auto;
  display: flex;
  flex-direction: column;
  gap: 16px;
}
.chat-content::-webkit-scrollbar {
  width: 5px;
}
.chat-content::-webkit-scrollbar-thumb {
  background: #d0d7e2;
  border-radius: 99px;
}
.message-item {
  display: flex;
  align-items: flex-start;
  gap: 10px;
  max-width: 80%;
}
.ai-item {
  align-self: flex-start;
}
.user-item {
  align-self: flex-end;
}
.avatar {
  width: 36px;
  height: 36px;
  border-radius: 50%;
  overflow: hidden;
  flex-shrink: 0;
  background: #f0f2f5;
}
.avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
.message-bubble {
  padding: 9px 13px;
  border-radius: 14px;
  line-height: 1.5;
  word-break: break-all;
  background: #fff;
  box-shadow: 0 1px 2px rgba(0,0,0,0.04);
}
.ai-bubble {
  background: #ffffff;
  color: #333;
  border-top-left-radius: 6px;
}
.user-bubble {
  background: #409eff;
  color: #fff;
  border-top-right-radius: 6px;
}

/* 垂直快捷提问样式 */
.quick-group {
  display: flex;
  flex-direction: column;
  gap: 8px;
  margin-bottom: 8px;
}
.quick-item {
  background: #ffffff;
  border: 1px solid #e4e7ed;
  border-radius: 12px;
  padding: 8px 14px;
  font-size: 14px;
  color: #409eff;
  cursor: pointer;
  transition: all 0.2s;
  max-width: 320px;
}
.quick-item:hover {
  background: #f0f7ff;
  border-color: #c6e2ff;
}

.chat-input-area {
  padding: 16px 20px;
  background: #fff;
  border-top: 1px solid #eaeef5;
  flex-shrink: 0;
  margin-top: auto;
}
.input-inner {
  display: flex;
  gap: 10px;
  align-items: flex-end;
}
.input-box {
  flex: 1;
}
.el-textarea__inner {
  border-radius: 12px;
  padding: 10px 14px;
  border: 1px solid #e5e6eb;
  resize: none;
  font-size: 14px;
  min-height: 44px;
}
.el-textarea__inner:focus {
  border-color: #409eff;
  box-shadow: 0 0 0 2px rgba(64, 158, 255, 0.08);
}
.action-btn {
  height: 44px;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  border-radius: 10px;
  font-size: 14px;
  padding: 0 16px;
  line-height: 1;
}
.voice-btn {
  color: #555;
  border-color: #dcdfe6;
}
.voice-btn:hover {
  background: #f5f7fa;
  border-color: #c6e2ff;
  color: #409eff;
}
.send-btn {
  background: #409eff;
  border-color: #409eff;
  color: #fff;
}
.send-btn:hover {
  background: #338eff;
  border-color: #338eff;
}
.send-btn:disabled {
  background: #bdd8ff;
  border-color: #bdd8ff;
}
</style>