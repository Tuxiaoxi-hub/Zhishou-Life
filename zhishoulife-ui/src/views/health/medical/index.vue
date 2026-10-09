<template>
  <div class="app-container">
    <div class="top-banner">
      <h1 class="banner-title">医疗常识 · 实用知识指南</h1>
      <p class="banner-desc">药物安全、就医流程、体检知识，日常就医用药更安心</p>
    </div>

    <!-- 3个导航对应3个轮播，配色沿用现有绿色系 -->
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
            <img src="@/static/medical/1.jpg" alt="药物安全" class="carousel-img">
            <div class="carousel-text">
              <h2>药物安全</h2>
              <p>规范用药 · 看懂禁忌规避风险</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/medical/2.jpg" alt="就医流程指南" class="carousel-img">
            <div class="carousel-text">
              <h2>就医流程指南</h2>
              <p>挂号报销 · 全程办事不迷茫</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/medical/3.jpg" alt="体检知识科普" class="carousel-img">
            <div class="carousel-text">
              <h2>体检知识科普</h2>
              <p>看懂报告 · 掌握自身健康状况</p>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="main-content">
      <div class="left-intro">
        <el-card shadow="hover" class="intro-card">
          <h3 class="intro-title">🏥 模块简介</h3>
          <p class="intro-content">
            医疗常识模块提供日常用药安全、就医办理流程、体检项目解读等实用医疗知识，
            内容通俗易懂，帮助大家安全用药、规范就医、看懂体检报告，守护全家健康。
          </p>
          
          <div class="data-card">
            <div class="data-item">
              <span class="data-num">50+</span>
              <span class="data-text">医疗知识点</span>
            </div>
            <div class="data-item">
              <span class="data-num">3</span>
              <span class="data-text">核心分类</span>
            </div>
            <div class="data-item">
              <span class="data-num">100%</span>
              <span class="data-text">实用易懂</span>
            </div>
          </div>

          <div class="guide-section">
            <h4 class="guide-title">📌 使用指南</h4>
            <ul class="guide-list">
              <li>点击右侧分类，查看对应详细医疗知识</li>
              <li>用药前仔细阅读说明，遵医嘱使用</li>
              <li>就医带齐证件，提前了解流程更省心</li>
            </ul>
          </div>

          <div class="scene-tags">
            <el-tag type="success" effect="plain">用药安全</el-tag>
            <el-tag type="success" effect="plain">就医指南</el-tag>
            <el-tag type="success" effect="plain">体检科普</el-tag>
          </div>
        </el-card>
      </div>

      <div class="right-link">
        <h3 class="link-header-new">
          <i class="el-icon-menu" style="color: #52c41a; margin-right: 10px;"></i>
          分类导航
        </h3>

        <div class="link-list">
          <el-card class="link-card" shadow="hover">
            <router-link to="/health/drug" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-first-aid-kit" />
              </div>
              <div class="link-content">
                <h4 class="link-title">药物安全</h4>
                <p class="link-desc">常用药品适应症、用法用量、禁忌与注意事项</p>
              </div>
              <div class="link-arrow">
                <i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>

          <el-card class="link-card" shadow="hover">
            <router-link to="/health/process" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-user" />
              </div>
              <div class="link-content">
                <h4 class="link-title">就医流程指南</h4>
                <p class="link-desc">挂号、医保报销、住院办理、异地就医等流程</p>
              </div>
              <div class="link-arrow">
                <i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>

          <el-card class="link-card" shadow="hover">
            <router-link to="/health/checkup" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-stethoscope" />
              </div>
              <div class="link-content">
                <h4 class="link-title">体检知识科普</h4>
                <p class="link-desc">体检项目解读、检查注意事项、适用人群</p>
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
                <a @click="$router.push('/health/drug')">布洛芬使用注意事项</a>
              </el-tag>
              <el-tag type="success" effect="plain">
                <a @click="$router.push('/health/process')">医保报销流程指南</a>
              </el-tag>
              <el-tag type="success" effect="plain">
                <a @click="$router.push('/health/checkup')">血常规项目解读</a>
              </el-tag>
            </div>
          </el-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default { name: "HealthMedicalIndex" };
</script>

<style scoped>
/* 原有CSS完全保留，仅新增适配绿色的轮播样式 */
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

/* 新增轮播样式，贴合当前绿色主题 */
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