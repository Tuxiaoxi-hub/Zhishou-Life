<template>
  <div class="app-container">
    <div class="top-banner">
      <h1 class="banner-title">考证考级 · 实用知识指南</h1>
      <p class="banner-desc">职业资格、语言等级、报考条件与备考规划，一站式提升竞争力</p>
    </div>

    <!-- 导航2个 → 轮播2个，绿色主题完全适配 -->
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
            <img src="@/static/cert/1.jpg" alt="职业资格证书" class="carousel-img">
            <div class="carousel-text">
              <h2>职业资格证书</h2>
              <p>报考条件 · 备考重点 · 就业方向</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/cert/2.jpg" alt="语言类证书" class="carousel-img">
            <div class="carousel-text">
              <h2>语言类证书</h2>
              <p>等级考试 · 高效备考 · 通关技巧</p>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="main-content">
      <div class="left-intro">
        <el-card shadow="hover" class="intro-card">
          <h3 class="intro-title">📜 模块简介</h3>
          <p class="intro-content">
            考证考级模块覆盖职业资格证书、语言类证书全场景，提供清晰报考条件、备考流程、学习规划与通关要点，
            面向学生与职场人，内容实用易懂，帮你高效备考、顺利拿证。
          </p>
          
          <div class="data-card">
            <div class="data-item">
              <span class="data-num">40+</span>
              <span class="data-text">热门证书</span>
            </div>
            <div class="data-item">
              <span class="data-num">2</span>
              <span class="data-text">核心分类</span>
            </div>
            <div class="data-item">
              <span class="data-num">100%</span>
              <span class="data-text">备考适用</span>
            </div>
          </div>

          <div class="guide-section">
            <h4 class="guide-title">📌 使用指南</h4>
            <ul class="guide-list">
              <li>点击右侧分类，查看对应证书详细信息</li>
              <li>内容包含报考条件、备考方法、通关技巧</li>
              <li>适合学生、职场人自我提升与职业规划</li>
            </ul>
          </div>

          <!-- 精简为3个标签，原色不变 -->
          <div class="scene-tags">
            <el-tag type="success" effect="plain">职业证书</el-tag>
            <el-tag type="success" effect="plain">语言考级</el-tag>
            <el-tag type="success" effect="plain">备考规划</el-tag>
          </div>
        </el-card>
      </div>

      <!-- 2个导航 → 右侧整体垂直居中 -->
      <div class="right-link" style="display: flex; flex-direction: column; justify-content: center;">
        <h3 class="link-header-new">
          <i class="el-icon-menu" style="color: #96C977; margin-right: 10px;"></i>
          分类导航
        </h3>

        <div class="link-list">
          <el-card class="link-card" shadow="hover">
            <router-link to="/study/profession" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-certificate" />
              </div>
              <div class="link-content">
                <h4 class="link-title">职业资格证书</h4>
                <p class="link-desc">热门职业证书报考条件、备考重点与就业方向</p>
              </div>
              <div class="link-arrow">
                <i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>

          <el-card class="link-card" shadow="hover">
            <router-link to="/study/language" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-comment" />
              </div>
              <div class="link-content">
                <h4 class="link-title">语言类证书</h4>
                <p class="link-desc">英语及小语种等级考试、备考方法与通关技巧</p>
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
                <a @click="$router.push('/study/profession')">计算机类证书报考指南</a>
              </el-tag>
              <el-tag type="success" effect="plain">
                <a @click="$router.push('/study/language')">四六级高效备考方案</a>
              </el-tag>
              <el-tag type="success" effect="plain">
                <a @click="$router.push('/study/profession')">财会类证书全解析</a>
              </el-tag>
            </div>
          </el-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default { name: "StudyCertIndex" };
</script>

<style scoped>
/* 你的原有CSS 100%完全保留，一字未改！！！ */
.app-container {
  background-color: #ffffff;
  min-height: calc(100vh - 120px);
  padding: 0 20px 30px;
}
.top-banner {
  background: linear-gradient(90deg, #F5F9F0 0%, #F0F7E8 100%);
  border-radius: 16px;
  padding: 40px 20px;
  margin: 20px 0;
  text-align: center;
}
.banner-title {
  font-size: 28px;
  color: #96C977;
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

/* 只新增轮播基础样式，完全适配绿色主题，不影响任何原有颜色 */
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
  color:#96C977;
  font-weight:bold;margin:0 0 6px;
}
.carousel-text p {
  font-size:15px;
  color:#666;
  margin:0;
}
:deep(.el-carousel__indicators){right:28px;bottom:20px;left:auto;}
:deep(.el-carousel__button){width:8px;height:8px;background:rgba(200,200,200,0.6);border-radius:50%;transition:0.2s;}
:deep(.el-carousel__button:hover){background:#96C977;}
:deep(.is-active .el-carousel__button){background:#96C977;}

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
  background-color: #F5F9F0; border-radius: 8px;
}
.data-item { flex: 1; text-align: center; }
.data-num { display: block; font-size: 24px; color: #96C977; font-weight: 600; }
.data-text { font-size: 12px; color: #666; }
.guide-section { margin: 0 0 20px; }
.guide-title { font-size: 16px; color: #333; margin: 0 0 8px; font-weight: 500; }
.guide-list { font-size: 13px; color: #666; padding-left: 20px; line-height: 1.8; }
.scene-tags { display: flex; flex-wrap: wrap; gap: 8px; }
.right-link { flex: 1; }
.link-header-new {
  font-size: 32px; font-weight: 600;
  background-image: linear-gradient(90deg, #96C977, #A8D48F);
  background-clip: text;
  -webkit-background-clip: text;
  color: transparent;
  margin: 20px;
  padding-left: 10px;
}
.link-list { display: flex; flex-direction: column; gap: 12px; }
.link-card { 
  border-radius: 10px; 
  border: 1px solid #E6F0D9; 
  transition: all 0.3s ease; 
}
.link-card:hover {
  background: linear-gradient(90deg, #F5F9F0 0%, #F0F7E8 100%);
  border-color: #D4E6BC;
  transform: translateX(5px);
}
.link-btn {
  display: flex; align-items: center; justify-content: space-between;
  width: 100%; height: 100%; padding: 20px 24px;
  text-decoration: none; color: #333;
}
.link-icon {
  width: 44px; height: 44px; border-radius: 50%;
  background-color: #E6F0D9; display: flex;
  align-items: center; justify-content: center; margin-right: 16px;
}
.link-icon i { font-size: 22px; color: #96C977; }
.link-content { flex: 1; }
.link-title { font-size: 17px; font-weight: 500; margin: 0 0 6px; }
.link-desc { font-size: 13px; color: #666; line-height: 1.5; }
.link-arrow i { font-size: 16px; color: #96C977; opacity: 0.8; }
.bottom-recommend { margin-top: 20px; }
.recommend-card { 
  border-radius: 12px; 
  padding: 20px 24px; 
  border: 1px solid #E6F0D9; 
}
.recommend-title { font-size: 18px; color: #333; margin: 0 0 16px; font-weight: 500; }
.recommend-list { display: flex; flex-wrap: wrap; gap: 12px; }
.recommend-list a { color: #96C977; text-decoration: none; }
.recommend-list a:hover { color: #85B866; text-decoration: underline; }
@media (max-width: 992px) {
  .main-content { flex-direction: column; }
  .left-intro { width: 100%; }
}
</style>