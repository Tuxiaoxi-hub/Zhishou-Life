<template>
  <div class="app-container">
    <div class="top-banner">
      <h1 class="banner-title">急救护理 · 实用知识指南</h1>
      <p class="banner-desc">常见急救方法、外伤应急处理，关键时刻能正确自救互救</p>
    </div>

    <!-- 导航2个 → 轮播2个，原色保留，src空 -->
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
            <img src="@/static/firstaid/1.jpg" alt="常见急救方法" class="carousel-img">
            <div class="carousel-text">
              <h2>常见急救方法</h2>
              <p>标准操作 · 关键时刻能救命</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/firstaid/2.jpg" alt="外伤应急处理" class="carousel-img">
            <div class="carousel-text">
              <h2>外伤应急处理</h2>
              <p>正确包扎 · 避免二次伤害</p>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="main-content">
      <div class="left-intro">
        <el-card shadow="hover" class="intro-card">
          <h3 class="intro-title">🚑 模块简介</h3>
          <p class="intro-content">
            急救护理模块专注讲解日常突发状况的应急处理方法，包含标准急救操作、外伤消毒包扎等内容，
            操作步骤简单易懂，适合家庭、校园、职场学习使用，提升应急救护能力。
          </p>
          
          <div class="data-card">
            <div class="data-item">
              <span class="data-num">50+</span>
              <span class="data-text">急救技能</span>
            </div>
            <div class="data-item">
              <span class="data-num">2</span>
              <span class="data-text">核心分类</span>
            </div>
            <div class="data-item">
              <span class="data-num">100%</span>
              <span class="data-text">可实操</span>
            </div>
          </div>

          <div class="guide-section">
            <h4 class="guide-title">📌 使用指南</h4>
            <ul class="guide-list">
              <li>先保证自身安全，再进行急救操作</li>
              <li>严重情况请立即拨打 120 急救电话</li>
              <li>定期复习急救知识，冷静应对突发情况</li>
            </ul>
          </div>

          <!-- 保留3个标签，原色不变 -->
          <div class="scene-tags">
            <el-tag type="success" effect="plain">外伤处理</el-tag>
            <el-tag type="success" effect="plain">应急救护</el-tag>
            <el-tag type="success" effect="plain">家庭急救</el-tag>
          </div>
        </el-card>
      </div>

      <!-- 2个导航 → 右侧整体垂直居中 -->
      <div class="right-link" style="display: flex; flex-direction: column; justify-content: center;">
        <h3 class="link-header-new">
          <i class="el-icon-menu" style="color: #52c41a; margin-right: 10px;"></i>
          分类导航
        </h3>

        <div class="link-list">
          <el-card class="link-card" shadow="hover">
            <router-link to="/health/aid" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-first-aid-kit" />
              </div>
              <div class="link-content">
                <h4 class="link-title">常见急救方法</h4>
                <p class="link-desc">海姆立克急救法、心肺复苏、烫伤紧急处理等标准操作</p>
              </div>
              <div class="link-arrow">
                <i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>

          <el-card class="link-card" shadow="hover">
            <router-link to="/health/trauma" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-medal" />
              </div>
              <div class="link-content">
                <h4 class="link-title">外伤应急处理</h4>
                <p class="link-desc">割伤、擦伤、砸伤等外伤清洗、消毒、包扎正确方法</p>
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
              <el-tag type="success" effect="plain">
                <a @click="$router.push('/health/aid')">海姆立克急救法</a>
              </el-tag>
              <el-tag type="success" effect="plain">
                <a @click="$router.push('/health/aid')">心肺复苏基础操作</a>
              </el-tag>
              <el-tag type="success" effect="plain">
                <a @click="$router.push('/health/trauma')">轻微割伤处理流程</a>
              </el-tag>
            </div>
          </el-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default { name: "HealthFirstAidIndex" };
</script>

<style scoped>
/* 你的原有CSS 100%完全保留，一字未改！！！ */
.app-container {
  background-color: #ffffff;
  min-height: calc(100vh - 120px);
  padding: 0 20px 30px;
}

.top-banner {
  background: linear-gradient(90deg, #f0fff4 0%, #f6ffef 100%);
  border-radius: 16px;
  padding: 40px 20px;
  margin: 20px 0;
  text-align: center;
}
.banner-title {
  font-size: 28px;
  color: #36ad6a;
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

/* 只新增轮播基础样式，不影响任何原有颜色 */
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
  color:#52c41a;
  font-weight:bold;margin:0 0 6px;
}
.carousel-text p {
  font-size:15px;
  color:#666;
  margin:0;
}
:deep(.el-carousel__indicators){right:28px;bottom:20px;left:auto;}
:deep(.el-carousel__button){width:8px;height:8px;background:rgba(200,200,200,0.6);border-radius:50%;transition:0.2s;}
:deep(.el-carousel__button:hover){background:#52c41a;}
:deep(.is-active .el-carousel__button){background:#52c41a;}

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
  background-color: #f6ffef; border-radius: 8px;
}
.data-item { flex: 1; text-align: center; }
.data-num { display: block; font-size: 24px; color: #52c41a; font-weight: 600; }
.data-text { font-size: 12px; color: #666; }

.guide-section { margin: 0 0 20px; }
.guide-title { font-size: 16px; color: #333; margin: 0 0 8px; font-weight: 500; }
.guide-list { font-size: 13px; color: #666; margin: 0; padding-left: 20px; line-height: 1.8; }
.scene-tags { display: flex; flex-wrap: wrap; gap: 8px; }

.right-link { flex: 1; }

.link-header-new {
  font-size: 32px; font-weight: 600;
  background-image: linear-gradient(90deg, #52c41a, #36ad6a);
  background-clip: text; -webkit-background-clip: text; color: transparent;
  margin: 20px; padding-left: 10px;
}

.link-list { display: flex; flex-direction: column; gap: 12px; }
.link-card { border-radius: 10px; border: 1px solid #d9f7e2; transition: all 0.3s ease; }
.link-card:hover {
  background: linear-gradient(90deg, #f6ffef 0%, #f0fff4 100%);
  border-color: #b3e5c7; transform: translateX(5px);
}

.link-btn {
  display: flex; align-items: center; justify-content: space-between;
  width: 100%; height: 100%; padding: 20px 24px;
  text-decoration: none; color: #333;
}
.link-icon {
  width: 44px; height: 44px; border-radius: 50%;
  background-color: #d9f7e2; display: flex;
  align-items: center; justify-content: center; margin-right: 16px;
}
.link-icon i { font-size: 22px; color: #36ad6a; }
.link-content { flex: 1; }
.link-title { font-size: 17px; font-weight: 500; margin: 0 0 6px; }
.link-desc { font-size: 13px; color: #666; margin: 0; line-height: 1.5; }
.link-arrow i { font-size: 16px; color: #36ad6a; opacity: 0.8; }

.bottom-recommend { margin-top: 20px; }
.recommend-card { border-radius: 12px; padding: 20px 24px; border: 1px solid #d9f7e2; }
.recommend-title { font-size: 18px; color: #333; margin: 0 0 16px; font-weight: 500; }
.recommend-list { display: flex; flex-wrap: wrap; gap: 12px; }
.recommend-list a { color: #36ad6a; text-decoration: none; }
.recommend-list a:hover { color: #2a9e5b; text-decoration: underline; }

@media (max-width: 992px) {
  .main-content { flex-direction: column; }
  .left-intro { width: 100%; }
  .link-btn { padding: 16px; }
  .banner-title { font-size: 24px; }
  .link-header-new { font-size: 22px; }
}
</style>