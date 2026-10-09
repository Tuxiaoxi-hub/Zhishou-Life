<template>
  <div class="app-container">
    <div class="top-banner">
      <h1 class="banner-title">网络安全 · 实用知识指南</h1>
      <p class="banner-desc">精选诈骗防范、隐私保护、账号安全三大核心板块，覆盖50+实用知识点，守护上网安全</p>
    </div>

    <div class="carousel-box">
      <el-carousel
        height="220px"
        arrow="never"
        indicator-position="bottom"
        autoplay
        interval="4000"
        loop
      >
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/network/1.jpg" alt="网络诈骗防范" class="carousel-img">
            <div class="carousel-text">
              <h2>网络诈骗防范</h2>
              <p style="color:#fff;">识破骗局 · 守护财产安全</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/network/2.jpg" alt="个人隐私保护" class="carousel-img">
            <div class="carousel-text">
              <h2>个人隐私保护</h2>
              <p style="color:#fff;">关闭权限 · 杜绝信息泄露</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/network/3.jpg" alt="账号安全防护" class="carousel-img">
            <div class="carousel-text">
              <h2>账号安全防护</h2>
              <p style="color:#fff;">强化密码 · 防止账号被盗</p>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="main-content">
      <div class="left-intro">
        <el-card shadow="hover" class="intro-card">
          <h3 class="intro-title">🔒 模块简介</h3>
          <p class="intro-content">
            网络安全模块聚焦日常上网的安全防护，从电信诈骗、网络诈骗的快速识别，到个人隐私信息的保护，再到各类账号的安全管理，
            适配手机上网、电脑办公、社交软件使用等多种场景，所有内容均基于网安部门建议，实用且易操作。
          </p>
          
          <div class="data-card">
            <div class="data-item">
              <span class="data-num">50+</span>
              <span class="data-text">实用知识点</span>
            </div>
            <div class="data-item">
              <span class="data-num">3</span>
              <span class="data-text">核心分类</span>
            </div>
            <div class="data-item">
              <span class="data-num">100%</span>
              <span class="data-text">网安认证</span>
            </div>
          </div>

          <div class="guide-section">
            <h4 class="guide-title">📌 使用指南</h4>
            <ul class="guide-list">
              <li>点击右侧分类，查看对应详细内容</li>
              <li>内容包含识别技巧、防护方法、应急处理</li>
              <li>可根据诈骗类型、账号类型快速查找</li>
            </ul>
          </div>

          <div class="scene-tags">
            <el-tag type="success" effect="plain">手机上网</el-tag>
            <el-tag type="success" effect="plain">电脑办公</el-tag>
            <el-tag type="success" effect="plain">社交软件</el-tag>
          </div>
        </el-card>
      </div>

      <div class="right-link">
        <h3 class="link-header-new">
          <i class="el-icon-menu" style="color: #409EFF; margin-right: 10px;"></i>
          分类导航
        </h3>

        <div class="link-list">
          <el-card class="link-card" shadow="hover">
            <router-link to="/safety/fraud" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-warning" />
              </div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">网络诈骗防范</h4>
                  <span class="link-desc">各类网络骗局识别与财产安全防护技巧</span>
                </div>
              </div>
              <div class="link-arrow">
                <i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>

          <el-card class="link-card" shadow="hover">
            <router-link to="/safety/privacy" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-lock" />
              </div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">个人隐私保护</h4>
                  <span class="link-desc">隐私泄露防护与个人信息安全管理方法</span>
                </div>
              </div>
              <div class="link-arrow">
                <i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>

          <el-card class="link-card" shadow="hover">
            <router-link to="/safety/account" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-user-solid" />
              </div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">账号安全防护</h4>
                  <span class="link-desc">常用账号安全设置与登录防护全攻略</span>
                </div>
              </div>
              <div class="link-arrow">
                <i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>
        </div>

        <div class="bottom-recommend">
          <el-card class="recommend-card">
            <h3 class="recommend-title">🔥 热门推荐</h3>
            <div class="recommend-list">
              <el-tag type="primary" effect="plain">
                <a @click="$router.push('/safety/fraud')">电信诈骗话术识别</a>
              </el-tag>
              <el-tag type="primary" effect="plain">
                <a @click="$router.push('/safety/privacy')">手机权限关闭技巧</a>
              </el-tag>
              <el-tag type="primary" effect="plain">
                <a @click="$router.push('/safety/account')">微信账号安全设置</a>
              </el-tag>
              <el-tag type="primary" effect="plain">
                <a @click="$router.push('/safety/fraud')">刷单诈骗防范方法</a>
              </el-tag>
              <el-tag type="primary" effect="plain">
                <a @click="$router.push('/safety/account')">支付密码设置技巧</a>
              </el-tag>
            </div>
          </el-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NetworkIndex",
  data() {
    return {};
  }
};
</script>

<style scoped>
.app-container {
  background-color: #ffffff;
  min-height: calc(100vh - 120px);
  padding: 0 20px 30px;
}

.top-banner {
  background: linear-gradient(90deg, #e8f4f8 0%, #f0f8fb 100%);
  border-radius: 16px;
  padding: 40px 20px;
  margin: 20px 0;
  text-align: center;
}
.banner-title {
  font-size: 28px;
  color: #1989fa;
  margin: 0 0 12px 0;
  font-weight: 600;
}
.banner-desc {
  font-size: 16px;
  color: #666;
  max-width: 800px;
  margin: 0 auto;
  line-height: 1.6;
}

.carousel-box {border-radius:14px;overflow:hidden;margin:0 0 24px;}
.carousel-item {width:100%;height:220px;position:relative;}
.carousel-img {width:100%;height:100%;object-fit:cover;}
.carousel-text {
  position: absolute;
  left: 48px;
  top: 50%;
  transform: translateY(-50%);
}
.carousel-text h2 {
  font-size:26px;
  color:#1890ff;
  font-weight:bold;margin:0 0 6px;
}
.carousel-text p {
  font-size:15px;
  color:#666;
  margin:0;
}
:deep(.el-carousel__indicators){right:28px;bottom:20px;left:auto;}
:deep(.el-carousel__button){width:8px;height:8px;background:rgba(200,200,200,0.6);border-radius:50%;transition:0.2s;}
:deep(.el-carousel__button:hover){background:#1890ff;}
:deep(.is-active .el-carousel__button){background:#1890ff;}

.main-content {
  display: flex;
  gap: 24px;
  margin-bottom: 30px;
}

.left-intro {
  width: 25%;
}
.intro-card {
  border-radius: 12px;
  padding: 24px;
  height: 100%;
}
.intro-title {
  font-size: 20px;
  color: #333;
  margin: 0 0 16px 0;
  font-weight: 500;
}
.intro-content {
  font-size: 14px;
  color: #666;
  line-height: 1.8;
  margin: 0 0 20px 0;
}

.data-card {
  display: flex;
  gap: 16px;
  margin: 0 0 20px 0;
  padding: 16px;
  background-color: #f8f9fa;
  border-radius: 8px;
}
.data-item {
  flex: 1;
  text-align: center;
}
.data-num {
  display: block;
  font-size: 24px;
  color: #1890ff;
  font-weight: 600;
}
.data-text {
  font-size: 12px;
  color: #666;
}

.guide-section {
  margin: 0 0 20px 0;
}
.guide-title {
  font-size: 16px;
  color: #333;
  margin: 0 0 8px 0;
  font-weight: 500;
}
.guide-list {
  font-size: 13px;
  color: #666;
  margin: 0;
  padding-left: 20px;
  line-height: 1.8;
}

.scene-tags {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
}

.right-link {
  flex: 1;
}

.link-header-new {
  font-size: 32px;
  font-weight: 600;
  color: transparent;
  background-image: linear-gradient(90deg, #1890ff, #409EFF);
  background-clip: text;
  -webkit-background-clip: text;
  margin: 20px 20px 20px 20px;
  padding-left: 10px;
}

.link-list {
  display: flex;
  flex-direction: column;
  gap: 12px;
}
.link-card {
  border-radius: 10px;
  border: 1px solid #f0f8fb;
  transition: all 0.3s ease;
}
.link-card:hover {
  background: linear-gradient(90deg, #f5fafe 0%, #e8f4f8 100%);
  border-color: #d1e9f6;
  transform: translateX(5px);
}

.link-btn {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  height: 100%;
  padding: 20px 24px;
  text-decoration: none;
  color: #333;
}
.link-icon {
  width: 44px;
  height: 44px;
  border-radius: 50%;
  background-color: #e8f4f8;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-right: 16px;
}
.link-icon i {
  font-size: 22px;
  color: #1890ff;
}
.link-content {
  flex: 1;
}
.link-row {
  display: flex;
  align-items: center;
  gap: 16px;
  flex-wrap: wrap;
}
.link-title {
  font-size: 18px;
  font-weight: bold;
  color: #1890ff;
  margin: 0;
}
.link-desc {
  font-size: 13px;
  color: #666;
}
.link-arrow i {
  font-size: 16px;
  color: #1890ff;
  opacity: 0.8;
}

.bottom-recommend {
  margin-top: 20px;
}
.recommend-card {
  border-radius: 12px;
  padding: 20px 24px;
  border: 1px solid #f0f8fb;
}
.recommend-title {
  font-size: 18px;
  color: #333;
  margin: 0 0 16px 0;
  font-weight: 500;
}
.recommend-list {
  display: flex;
  flex-wrap: wrap;
  gap: 12px;
}
.recommend-list a {
  color: #1890ff;
  text-decoration: none;
}
.recommend-list a:hover {
  color: #096dd9;
  text-decoration: underline;
}

@media (max-width: 992px) {
  .main-content {
    flex-direction: column;
  }
  .left-intro {
    width: 100%;
  }
  .link-btn {
    padding: 16px;
  }
  .banner-title {
    font-size: 24px;
  }
  .link-header-new {
    font-size: 28px;
  }
}
</style>