<template>
  <div class="register">
    <el-form ref="registerRef" :model="registerForm" :rules="registerRules" class="register-form">
      <h3 class="title">知守生活</h3>
      <el-form-item prop="username">
        <el-input 
          v-model="registerForm.username" 
          type="text" 
          size="large" 
          auto-complete="off" 
          placeholder="账号"
        >
          <template #prefix><svg-icon icon-class="user" class="el-input__icon input-icon" /></template>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          v-model="registerForm.password"
          type="password"
          size="large" 
          auto-complete="off"
          placeholder="密码"
          @keyup.enter="handleRegister"
        >
          <template #prefix><svg-icon icon-class="password" class="el-input__icon input-icon" /></template>
        </el-input>
      </el-form-item>
      <el-form-item prop="confirmPassword">
        <el-input
          v-model="registerForm.confirmPassword"
          type="password"
          size="large" 
          auto-complete="off"
          placeholder="确认密码"
          @keyup.enter="handleRegister"
        >
          <template #prefix><svg-icon icon-class="password" class="el-input__icon input-icon" /></template>
        </el-input>
      </el-form-item>
      <!-- 新增：手机号字段（和原版布局对齐） -->
      <el-form-item prop="phonenumber">
        <el-input
          v-model="registerForm.phonenumber"
          type="text"
          size="large" 
          auto-complete="off"
          placeholder="手机号"
          @keyup.enter="handleRegister"
        >
          <template #prefix><svg-icon icon-class="user" class="el-input__icon input-icon" /></template>
        </el-input>
      </el-form-item>
      <!-- 新增：邮箱字段（和原版布局对齐） -->
      <el-form-item prop="email">
        <el-input
          v-model="registerForm.email"
          type="text"
          size="large" 
          auto-complete="off"
          placeholder="邮箱"
          @keyup.enter="handleRegister"
        >
          <template #prefix><svg-icon icon-class="user" class="el-input__icon input-icon" /></template>
        </el-input>
      </el-form-item>
      <el-form-item prop="code" v-if="captchaEnabled">
        <el-input
          size="large" 
          v-model="registerForm.code"
          auto-complete="off"
          placeholder="验证码"
          style="width: 63%"
          @keyup.enter="handleRegister"
        >
          <template #prefix><svg-icon icon-class="validCode" class="el-input__icon input-icon" /></template>
        </el-input>
        <div class="register-code">
          <img :src="codeUrl" @click="getCode" class="register-code-img"/>
        </div>
      </el-form-item>
      <el-form-item style="width:100%;">
        <el-button
          :loading="loading"
          size="large" 
          type="primary"
          style="width:100%;"
          @click.prevent="handleRegister"
        >
          <span v-if="!loading">注 册</span>
          <span v-else>注 册 中...</span>
        </el-button>
        <div style="float: right;">
          <router-link class="link-type" :to="'/login'">使用已有账户登录</router-link>
        </div>
      </el-form-item>
    </el-form>
    <!--  底部  -->
    <div class="el-register-footer">
      <span>本网站由长治学院计算机学生自主创作 采用若依框架</span>
    </div>
  </div>
</template>

<script setup>
// 补充缺失的核心依赖（原版代码漏加的）
import { ref, getCurrentInstance } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessageBox, ElMessage } from "element-plus"; // 新增ElMessage提示错误
// 替换为注册专属API文件（避免和登录接口混在一起）
import { getCodeImg } from "@/api/login";
import { register } from "@/api/register";

// 修复原版缺失的router和proxy
const router = useRouter();
const { proxy } = getCurrentInstance();

// 注册表单：新增手机号、邮箱字段，保留原版所有字段
const registerForm = ref({
  username: "",
  password: "",
  confirmPassword: "",
  phonenumber: "", // 新增手机号
  email: "",       // 新增邮箱
  code: "",
  uuid: ""
});

// 原版密码一致性校验：保留
const equalToPassword = (rule, value, callback) => {
  if (registerForm.value.password !== value) {
    callback(new Error("两次输入的密码不一致"));
  } else {
    callback();
  }
};

// 新增：手机号格式校验
const validatePhone = (rule, value, callback) => {
  const reg = /^1[3-9]\d{9}$/;
  if (!value) {
    callback(new Error("请输入手机号"));
  } else if (!reg.test(value)) {
    callback(new Error("请输入正确的手机号"));
  } else {
    callback();
  }
};

// 新增：邮箱格式校验
const validateEmail = (rule, value, callback) => {
  const reg = /^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  if (!value) {
    callback(new Error("请输入邮箱"));
  } else if (!reg.test(value)) {
    callback(new Error("请输入正确的邮箱"));
  } else {
    callback();
  }
};

// 注册规则：保留原版所有规则 + 新增手机号/邮箱校验
const registerRules = {
  username: [
    { required: true, trigger: "blur", message: "请输入您的账号" },
    { min: 2, max: 20, message: "用户账号长度必须介于 2 和 20 之间", trigger: "blur" }
  ],
  password: [
    { required: true, trigger: "blur", message: "请输入您的密码" },
    { min: 5, max: 20, message: "用户密码长度必须介于 5 和 20 之间", trigger: "blur" }
  ],
  confirmPassword: [
    { required: true, trigger: "blur", message: "请再次输入您的密码" },
    { required: true, validator: equalToPassword, trigger: "blur" }
  ],
  phonenumber: [ // 新增手机号校验
    { required: true, validator: validatePhone, trigger: "blur" }
  ],
  email: [ // 新增邮箱校验
    { required: true, validator: validateEmail, trigger: "blur" }
  ],
  code: [{ required: true, trigger: "change", message: "请输入验证码" }]
};

// 原版变量：保留
const codeUrl = ref("");
const loading = ref(false);
const captchaEnabled = ref(true);

// 注册方法：核心修复参数名 + 新增错误提示
function handleRegister() {
  proxy.$refs.registerRef.validate(valid => {
    if (valid) {
      loading.value = true;
      // ========== 核心修复：参数名从userName改为username（小写），匹配后端 ==========
      const params = {
        username: registerForm.value.username, // 关键：和后端registerBody.getUsername()匹配
        password: registerForm.value.password,
        phonenumber: registerForm.value.phonenumber,
        email: registerForm.value.email,
        code: registerForm.value.code,
        uuid: registerForm.value.uuid
      };
      register(params).then(res => {
        if (res.code === 200) { // 匹配后端返回的成功状态码
          const username = registerForm.value.username;
          ElMessageBox.alert("<font color='red'>恭喜你，您的账号 " + username + " 注册成功！</font>", "系统提示", {
            dangerouslyUseHTMLString: true,
            type: "success",
          }).then(() => {
            router.push("/login");
          }).catch(() => {});
        } else {
          ElMessage.error(res.msg || "注册失败"); // 显示后端返回的错误提示
          loading.value = false;
          if (captchaEnabled.value) {
            getCode(); // 验证码刷新
          }
        }
      }).catch(error => {
        // 捕获网络/接口错误
        ElMessage.error("注册请求失败，请检查网络或接口");
        loading.value = false;
        if (captchaEnabled.value) {
          getCode();
        }
        console.error("注册错误：", error); // 控制台打印错误，方便排查
      });
    }
  });
}

// 原版验证码方法：保留 + 修复captchaEnabled的.value
function getCode() {
  getCodeImg().then(res => {
    captchaEnabled.value = res.captchaEnabled === undefined ? true : res.captchaEnabled;
    if (captchaEnabled.value) {
      codeUrl.value = "data:image/gif;base64," + res.img;
      registerForm.value.uuid = res.uuid;
    }
  }).catch(() => {
    ElMessage.error("验证码获取失败");
  });
}

// 初始化验证码：保留
getCode();
</script>

<style lang='scss' scoped>
// 100%保留原版样式，无任何修改
.register {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-image: url("../assets/images/login-background.jpg");
  background-size: cover;
}
.title {
  margin: 0px auto 30px auto;
  text-align: center;
  color: #707070;
}

.register-form {
  border-radius: 6px;
  background: #ffffff;
  width: 400px;
  padding: 25px 25px 5px 25px;
  .el-input {
    height: 40px;
    input {
      height: 40px;
    }
  }
  .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 0px;
  }
}
.register-tip {
  font-size: 13px;
  text-align: center;
  color: #bfbfbf;
}
.register-code {
  width: 33%;
  height: 40px;
  float: right;
  img {
    cursor: pointer;
    vertical-align: middle;
  }
}
.el-register-footer {
  height: 40px;
  line-height: 40px;
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  color: #fff;
  font-family: Arial;
  font-size: 12px;
  letter-spacing: 1px;
}
.register-code-img {
  height: 40px;
  padding-left: 12px;
}
</style>