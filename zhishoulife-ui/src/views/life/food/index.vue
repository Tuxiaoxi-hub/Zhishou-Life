<template>
  <div class="app-container">
    <div class="header-spacing"></div>

    <div class="top-banner">
      <h1 class="banner-title">饮食美食 · 实用知识指南</h1>
      <p class="banner-desc">精选食材处理、烹饪技巧、饮食搭配三大核心板块，让日常饮食更健康美味</p>
    </div>

    <!-- 轮播：版式不动，图片src全空 -->
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
            <img src="@/static/food/1.jpg" alt="食材挑选与保存" class="carousel-img">
            <div class="carousel-text">
              <h2>食材挑选与保存</h2>
              <p>新鲜选材 · 长效保鲜更省心</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/food/2.jpg" alt="家常菜烹饪" class="carousel-img">
            <div class="carousel-text">
              <h2>家常菜烹饪</h2>
              <p>新手易懂 · 家常菜谱零失败</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/food/3.jpg" alt="饮食禁忌与搭配" class="carousel-img">
            <div class="carousel-text">
              <h2>饮食禁忌与搭配</h2>
              <p>科学搭配 · 守护日常饮食健康</p>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="main-content">
      <div class="left-intro">
        <el-card shadow="hover" class="intro-card">
          <h3 class="intro-title">🍽️ 模块简介</h3>
          <p class="intro-content">
            饮食美食模块覆盖食材挑选保鲜、家常烹饪教学、科学饮食搭配三大场景，内容简单实用、上手就能用，适配家庭日常、新手做饭、健康养生需求。
          </p>

          <div class="data-card">
            <div class="data-item">
              <span class="data-num">52+</span>
              <span class="data-text">实用知识点</span>
            </div>
            <div class="data-item">
              <span class="data-num">3</span>
              <span class="data-text">核心分类</span>
            </div>
            <div class="data-item">
              <span class="data-num">100%</span>
              <span class="data-text">家庭适配</span>
            </div>
          </div>

          <div class="guide-section">
            <h4 class="guide-title">📌 使用指南</h4>
            <ul class="guide-list">
              <li>点击右侧分类查看详细方法</li>
              <li>按食材类型、烹饪需求快速查找</li>
              <li>所有方法安全易操作</li>
            </ul>
          </div>

          <div class="scene-tags">
            <el-tag type="warning" effect="plain">家庭烹饪</el-tag>
            <el-tag type="warning" effect="plain">新手入门</el-tag>
            <el-tag type="warning" effect="plain">健康饮食</el-tag>
          </div>
        </el-card>
      </div>

      <div class="right-link">
        <h3 class="link-header-new">
          <i class="el-icon-menu" style="color:#fa8c16;margin-right:10px"></i>
          分类导航
        </h3>
        <div class="link-list">
          <el-card class="link-card" shadow="hover">
            <router-link to="/life/select" class="link-btn">
              <div class="link-icon"><i class="el-icon-shopping-basket" /></div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">食材挑选与保存</h4>
                  <span class="link-desc">涵盖蔬菜、肉类、海鲜、干货等食材，新鲜挑选+长效保存</span>
                </div>
              </div>
              <div class="link-arrow"><i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>
          <el-card class="link-card" shadow="hover">
            <router-link to="/life/cook" class="link-btn">
              <div class="link-icon"><i class="el-icon-fire" /></div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">家常菜烹饪</h4>
                  <span class="link-desc">家常菜品详细配料+分步教程，新手也能零失败</span>
                </div>
              </div>
              <div class="link-arrow"><i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>
          <el-card class="link-card" shadow="hover">
            <router-link to="/life/taboo" class="link-btn">
              <div class="link-icon"><i class="el-icon-warning-outline" /></div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">饮食禁忌与搭配</h4>
                  <span class="link-desc">常见饮食搭配误区解析，科学建议守护健康</span>
                </div>
              </div>
              <div class="link-arrow"><i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>
        </div>

        <div class="bottom-recommend">
          <el-card class="recommend-card">
            <h3 class="recommend-title">🔥 热门推荐</h3>
            <div class="recommend-list">
              <el-tag type="warning" effect="plain">
                <a @click="$router.push('/life/select')">新鲜蔬菜挑选技巧</a>
              </el-tag>
              <el-tag type="warning" effect="plain">
                <a @click="$router.push('/life/cook')">红烧肉简易教程</a>
              </el-tag>
              <el-tag type="warning" effect="plain">
                <a @click="$router.push('/life/taboo')">海鲜与啤酒同食禁忌</a>
              </el-tag>
            </div>
          </el-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default { name: "FoodIndex" }
</script>

<style scoped>
/* 完全沿用你的固定版式CSS，一字没改 */
.header-spacing {height: 30px;}
.app-container {background:#fff;padding:0 20px 30px;}

.top-banner {
  background:linear-gradient(90deg, #FFF5E6 0%, #FFEFD2 100%);
  border-radius:16px;padding:20px;margin:0 0 20px;text-align:center;
}
.banner-title {font-size:24px;color:#FA8C16;margin:0 0 8px;font-weight:600;}
.banner-desc {font-size:15px;color:#666;margin:0;}

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
  color:#FA8C16;
  font-weight:bold;margin:0 0 6px;
}
.carousel-text p {
  font-size:15px;
  color:#ffffff;
  margin:0;
}

:deep(.el-carousel__indicators){right:28px!important;bottom:20px!important;left:auto!important;}
:deep(.el-carousel__button){width:8px;height:8px;background:rgba(200,200,200,0.6);border-radius:50%;transition:0.2s;}
:deep(.el-carousel__button:hover){background:#FA8C16;}
:deep(.is-active .el-carousel__button){background:#FA8C16;}

.main-content {display:flex;gap:24px;}
.left-intro {width:26%;}

.intro-card {border-radius:12px;padding:36px;height:100%;}
.intro-title {font-size:20px;color:#333;margin:0 0 30px;}
.intro-content {font-size:14px;color:#666;line-height:1.8;margin:0 0 40px;}

.data-card {
  display:flex;gap:16px;padding:22px;
  background:#FFF5E6;border-radius:8px;margin:0 0 40px;
}
.data-item {flex:1;text-align:center;display:flex;flex-direction:column;align-items:center;}
.data-num {font-size:22px;color:#FA8C16;font-weight:600;line-height:1.2;}
.data-text {font-size:13px;color:#666;margin-top:4px;}

.guide-section {margin:0 0 40px;}
.guide-title {font-size:16px;color:#333;margin:0 0 12px;}
.guide-list {font-size:13px;color:#666;padding-left:20px;line-height:1.8;margin:0;}
.scene-tags {display:flex;gap:8px;}

.right-link {flex:1;}
.link-header-new {font-size:26px;font-weight:600;background:linear-gradient(90deg,#FA8C16,#E67700);background-clip:text;-webkit-background-clip:text;color:transparent;margin:0 0 16px;}
.link-list {display:flex;flex-direction:column;gap:16px;margin-bottom:20px;}
.link-card {border-radius:10px;border:1px solid #FFE0B2;}
.link-btn {display:flex;align-items:center;padding:24px 28px;text-decoration:none;color:#333;}
.link-icon {width:44px;height:44px;border-radius:50%;background:#FFE0B2;display:flex;align-items:center;justify-content:center;margin-right:16px;}
.link-icon i {font-size:22px;color:#FA8C16;}
.link-row {display:flex;align-items:center;gap:16px;flex-wrap:wrap;}
.link-title {font-size:18px;font-weight:bold;color:#FA8C16;margin:0;}
.link-desc {font-size:13px;color:#666;}
.link-arrow i {font-size:16px;color:#FA8C16;opacity:0.8;}

.recommend-card {border-radius:12px;padding:16px 24px;border:1px solid #FFE0B2;}
.recommend-title {font-size:18px;color:#333;margin:0 0 12px;}
.recommend-list {display:flex;flex-wrap:wrap;gap:12px;}
.recommend-list a {color:#FA8C16;text-decoration:none;}

@media (max-width:992px){
  .main-content{flex-direction:column;}
  .left-intro{width:100%;}
}
</style>