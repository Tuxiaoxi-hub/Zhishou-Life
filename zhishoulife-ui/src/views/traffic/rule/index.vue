<template>
  <div class="app-container">
    <div class="top-banner">
      <h1 class="banner-title">交通规则 · 实用知识指南</h1>
      <p class="banner-desc">交通标志、通行规范、出行礼仪，全面掌握安全出行规则</p>
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
            <img src="@/static/rule/1.jpg" alt="交通标志识别" class="carousel-img">
            <div class="carousel-text">
              <h2>交通标志识别</h2>
              <p style="color:#fff;">禁令 · 指示 · 警告 · 指路标志全图解</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/rule/2.jpg" alt="交通通行规则" class="carousel-img">
            <div class="carousel-text">
              <h2>交通通行规则</h2>
              <p style="color:#fff;">路口 · 车道 · 红绿灯 · 文明出行规范</p>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="main-content">
      <div class="left-intro">
        <el-card shadow="hover" class="intro-card">
          <h3 class="intro-title">🚦 模块简介</h3>
          <p class="intro-content">
            交通规则模块覆盖道路标志识别、通行规范、红绿灯规则、行人与车辆安全礼仪，
            内容通俗易懂，适合驾车、骑行、步行全场景，帮你安全文明出行。
          </p>
          
          <div class="data-card">
            <div class="data-item">
              <span class="data-num">40+</span>
              <span class="data-text">交通知识点</span>
            </div>
            <div class="data-item">
              <span class="data-num">2</span>
              <span class="data-text">核心分类</span>
            </div>
            <div class="data-item">
              <span class="data-num">100%</span>
              <span class="data-text">出行必备</span>
            </div>
          </div>

          <div class="guide-section">
            <h4 class="guide-title">📌 使用指南</h4>
            <ul class="guide-list">
              <li>点击右侧分类，查看对应交通规则内容</li>
              <li>内容包含标志识别、通行规范、安全提示</li>
              <li>适合司机、行人、学生、日常出行使用</li>
            </ul>
          </div>

          <!-- 精简为3个标签 → 统一风格 -->
          <div class="scene-tags">
            <el-tag type="primary" effect="plain">交通标志</el-tag>
            <el-tag type="primary" effect="plain">通行规则</el-tag>
            <el-tag type="primary" effect="plain">文明出行</el-tag>
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
            <router-link to="/traffic/sign" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-traffic-light" />
              </div>
              <div class="link-content">
                <h4 class="link-title">交通标志识别</h4>
                <p class="link-desc">禁令、指示、警告、指路标志全类别图解记忆</p>
              </div>
              <div class="link-arrow">
                <i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>

          <el-card class="link-card" shadow="hover">
            <router-link to="/traffic/common" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-road" />
              </div>
              <div class="link-content">
                <h4 class="link-title">交通通行规则</h4>
                <p class="link-desc">红绿灯、车道、转弯、让行等日常通行规范</p>
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
                <a @click="$router.push('/traffic/sign')">常见交通标志速记</a>
              </el-tag>
              <el-tag type="primary" effect="plain">
                <a @click="$router.push('/traffic/common')">路口通行规则</a>
              </el-tag>
              <el-tag type="primary" effect="plain">
                <a @click="$router.push('/traffic/sign')">指示标志快速识别</a>
              </el-tag>
            </div>
          </el-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default { name: "TrafficRuleIndex" };
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