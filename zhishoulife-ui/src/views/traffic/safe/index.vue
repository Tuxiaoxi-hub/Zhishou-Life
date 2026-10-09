<template>
  <div class="app-container">
    <div class="top-banner">
      <h1 class="banner-title">出行安全 · 实用知识指南</h1>
      <p class="banner-desc">公共交通、自驾出行、应急处理，全方位守护出行安全</p>
    </div>

    <!-- 导航2个 → 轮播2个，紫色主题完全适配 -->
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
            <img src="@/static/safe/1.jpg" alt="公共出行安全" class="carousel-img">
            <div class="carousel-text">
              <h2>公共出行安全</h2>
              <p style="color:#fff;">地铁 · 公交 · 网约车 · 防盗防骗</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/safe/2.jpg" alt="自驾出行安全" class="carousel-img">
            <div class="carousel-text">
              <h2>自驾出行安全</h2>
              <p style="color:#fff;">行车检查 · 应急处理 · 安全指南</p>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="main-content">
      <div class="left-intro">
        <el-card shadow="hover" class="intro-card">
          <h3 class="intro-title">🛡️ 模块简介</h3>
          <p class="intro-content">
            出行安全模块覆盖公共交通、自驾出行、长途旅行等场景的安全知识，
            包含防骗、防盗、应急处理、避险技巧，适合日常出行、旅游、通勤全场景使用。
          </p>
          
          <div class="data-card">
            <div class="data-item">
              <span class="data-num">40+</span>
              <span class="data-text">安全技巧</span>
            </div>
            <div class="data-item">
              <span class="data-num">2</span>
              <span class="data-text">核心分类</span>
            </div>
            <div class="data-item">
              <span class="data-num">100%</span>
              <span class="data-text">安全实用</span>
            </div>
          </div>

          <div class="guide-section">
            <h4 class="guide-title">📌 使用指南</h4>
            <ul class="guide-list">
              <li>点击右侧分类，查看对应出行安全内容</li>
              <li>内容包含避险、防盗、应急、自救技巧</li>
              <li>适合通勤、旅游、长途出行各类场景</li>
            </ul>
          </div>

          <!-- 精简为3个标签 → 统一风格 -->
          <div class="scene-tags">
            <el-tag type="primary" effect="plain">公共出行</el-tag>
            <el-tag type="primary" effect="plain">自驾安全</el-tag>
            <el-tag type="primary" effect="plain">防盗防骗</el-tag>
          </div>
        </el-card>
      </div>

      <!-- 右侧整体垂直居中 → 统一风格 -->
      <div class="right-link" style="display: flex; flex-direction: column; justify-content: center;">
        <h3 class="link-header-new">
          <i class="el-icon-menu" style="color: #A997D8; margin-right: 10px;"></i>
          分类导航
        </h3>

        <div class="link-list">
          <el-card class="link-card" shadow="hover">
            <router-link to="/traffic/public" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-bus" />
              </div>
              <div class="link-content">
                <h4 class="link-title">公共出行安全</h4>
                <p class="link-desc">地铁、公交、网约车安全注意事项与防骗技巧</p>
              </div>
              <div class="link-arrow">
                <i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>

          <el-card class="link-card" shadow="hover">
            <router-link to="/traffic/drive" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-car" />
              </div>
              <div class="link-content">
                <h4 class="link-title">自驾出行安全</h4>
                <p class="link-desc">行车检查、路况应对、应急处理安全指南</p>
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
                <a @click="$router.push('/traffic/public')">网约车安全指南</a>
              </el-tag>
              <el-tag type="primary" effect="plain">
                <a @click="$router.push('/traffic/drive')">自驾出行检查清单</a>
              </el-tag>
              <el-tag type="primary" effect="plain">
                <a @click="$router.push('/traffic/public')">公交地铁防盗技巧</a>
              </el-tag>
            </div>
          </el-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default { name: "TrafficSafeIndex" };
</script>

<style scoped>
.app-container {
  background-color: #ffffff;
  min-height: calc(100vh - 120px);
  padding: 0 20px 30px;
}
.top-banner {
  background: linear-gradient(90deg, #F6F4FA 0%, #F1EFF8 100%);
  border-radius: 16px;
  padding: 40px 20px;
  margin: 20px 0;
  text-align: center;
}
.banner-title {
  font-size: 28px;
  color: #A997D8;
  margin: 0 0 12px;
  font-weight: 600;
}
.banner-desc {
  font-size: 16px;
  color: #666;
  max-width: 800px;
  margin: 0 auto;
  line-height: 1.6;
}

/* 轮播样式 → 完全统一模板 */
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
  color:#A997D8;
  font-weight:bold;margin:0 0 6px;
}
.carousel-text p {
  font-size:15px;
  color:#666;
  margin:0;
}
:deep(.el-carousel__indicators){right:28px;bottom:20px;left:auto;}
:deep(.el-carousel__button){width:8px;height:8px;background:rgba(200,200,200,0.6);border-radius:50%;transition:0.2s;}
:deep(.el-carousel__button:hover){background:#A997D8;}
:deep(.is-active .el-carousel__button){background:#A997D8;}

.main-content {
  display: flex;
  gap: 24px;
  margin-bottom: 30px;
}
.left-intro { width: 25%; }
.intro-card { border-radius: 12px; padding: 24px; height: 100%; }
.intro-title { font-size: 20px; color: #333; margin: 0 0 16px; font-weight: 500; }
.intro-content { font-size: 14px; color: #666; line-height: 1.8; margin: 0 0 20px; }
.data-card {
  display: flex; gap: 16px; margin: 0 0 20px; padding: 16px;
  background-color: #F6F4FA; border-radius: 8px;
}
.data-item { flex: 1; text-align: center; }
.data-num { display: block; font-size: 24px; color: #A997D8; font-weight: 600; }
.data-text { font-size: 12px; color: #666; }
.guide-section { margin: 0 0 20px; }
.guide-title { font-size: 16px; color: #333; margin: 0 0 8px; font-weight: 500; }
.guide-list { font-size: 13px; color: #666; padding-left: 20px; line-height: 1.8; }
.scene-tags { display: flex; flex-wrap: wrap; gap: 8px; }
.right-link { flex: 1; }
.link-header-new {
  font-size: 32px; font-weight: 600;
  background-image: linear-gradient(90deg, #A997D8, #9A86CC);
  background-clip: text;
  -webkit-background-clip: text;
  color: transparent;
  margin: 20px;
  padding-left: 10px;
}
.link-list { display: flex; flex-direction: column; gap: 12px; }
.link-card { 
  border-radius: 10px; 
  border: 1px solid #E6E1F5; 
  transition: all 0.3s ease; 
}
.link-card:hover {
  background: linear-gradient(90deg, #F6F4FA 0%, #F1EFF8 100%);
  border-color: #D4C9E6;
  transform: translateX(5px);
}
.link-btn {
  display: flex; align-items: center; justify-content: space-between;
  width: 100%; height: 100%; padding: 20px 24px;
  text-decoration: none; color: #333;
}
.link-icon {
  width: 44px; height: 44px; border-radius: 50%;
  background-color: #E6E1F5; display: flex;
  align-items: center; justify-content: center; margin-right: 16px;
}
.link-icon i { font-size: 22px; color: #A997D8; }
.link-content { flex: 1; }
.link-title { font-size: 17px; font-weight: 500; margin: 0 0 6px; }
.link-desc { font-size: 13px; color: #666; line-height: 1.5; }
.link-arrow i { font-size: 16px; color: #A997D8; opacity: 0.8; }
.bottom-recommend { margin-top: 20px; }
.recommend-card { 
  border-radius: 12px; 
  padding: 20px 24px; 
  border: 1px solid #E6E1F5; 
}
.recommend-title { font-size: 18px; color: #333; margin: 0 0 16px; font-weight: 500; }
.recommend-list { display: flex; flex-wrap: wrap; gap: 12px; }
.recommend-list a { color: #A997D8; text-decoration: none; }
.recommend-list a:hover { color: #8A76BF; text-decoration: underline; }
@media (max-width: 992px) {
  .main-content { flex-direction: column; }
  .left-intro { width: 100%; }
}
</style>