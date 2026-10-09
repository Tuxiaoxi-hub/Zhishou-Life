<template>
  <div class="app-container">
    <div class="header-spacing"></div>

    <div class="top-banner">
      <h1 class="banner-title">家居收纳 · 实用知识指南</h1>
      <p class="banner-desc">空间优化、物品分类、收纳技巧，让家里整洁有序、空间利用率翻倍</p>
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
            <img src="@/static/appliance/1.jpg" alt="空间收纳技巧" class="carousel-img">
            <div class="carousel-text">
              <h2>空间收纳技巧</h2>
              <p>科学规划 · 小户型空间大变身</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/appliance/2.jpg" alt="物品收纳整理" class="carousel-img">
            <div class="carousel-text">
              <h2>物品收纳整理</h2>
              <p>分类摆放 · 居家整洁更省心</p>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="main-content">
      <div class="left-intro">
        <el-card shadow="hover" class="intro-card">
          <h3 class="intro-title">📦 模块简介</h3>
          <p class="intro-content">
            家居收纳模块专注家庭空间规划与物品整理技巧，覆盖客厅、卧室、厨房、衣柜等全场景，
            教你高效收纳、科学分类、空间最大化，简单易操作，适合所有家庭使用。
          </p>
          
          <div class="data-card">
            <div class="data-item">
              <span class="data-num">50+</span>
              <span class="data-text">收纳技巧</span>
            </div>
            <div class="data-item">
              <span class="data-num">2</span>
              <span class="data-text">核心分类</span>
            </div>
            <div class="data-item">
              <span class="data-num">100%</span>
              <span class="data-text">家庭适用</span>
            </div>
          </div>

          <div class="guide-section">
            <h4 class="guide-title">📌 使用指南</h4>
            <ul class="guide-list">
              <li>点击右侧分类，查看对应详细收纳知识</li>
              <li>内容包含收纳方法、空间规划、整理步骤</li>
              <li>适合全屋整理、局部改造、日常维护使用</li>
            </ul>
          </div>

          <div class="scene-tags">
            <el-tag type="primary" effect="plain">空间规划</el-tag>
            <el-tag type="primary" effect="plain">物品整理</el-tag>
            <el-tag type="primary" effect="plain">高效收纳</el-tag>
          </div>
        </el-card>
      </div>

      <!-- 清除垂直居中，恢复正常布局 → 和你模板统一 -->
      <div class="right-link">
        <h3 class="link-header-new">
          <i class="el-icon-menu" style="color: #8B98D4; margin-right: 10px;"></i>
          分类导航
        </h3>

        <div class="link-list">
          <el-card class="link-card" shadow="hover">
            <router-link to="/home/space" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-house" />
              </div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">空间收纳技巧</h4>
                  <span class="link-desc">全屋空间科学规划与利用率优化方法</span>
                </div>
              </div>
              <div class="link-arrow">
                <i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>

          <el-card class="link-card" shadow="hover">
            <router-link to="/home/goods" class="link-btn">
              <div class="link-icon">
                <i class="el-icon-box" />
              </div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">物品收纳整理</h4>
                  <span class="link-desc">各类生活用品分类收纳与整洁摆放技巧</span>
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
                <a @click="$router.push('/home/space')">小户型空间扩容技巧</a>
              </el-tag>
              <el-tag type="primary" effect="plain">
                <a @click="$router.push('/home/goods')">衣柜高效收纳方法</a>
              </el-tag>
              <el-tag type="primary" effect="plain">
                <a @click="$router.push('/home/space')">厨房空间规划指南</a>
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
  name: "HomeStorageIndex"
};
</script>

<style scoped>
.app-container {
  background-color: #ffffff;
  min-height: calc(100vh - 120px);
  padding: 0 20px 30px;
}

.top-banner {
  background: linear-gradient(90deg, #F5F7FB 0%, #F0F2FA 100%);
  border-radius: 16px;
  padding: 40px 20px;
  margin: 20px 0;
  text-align: center;
}
.banner-title {
  font-size: 28px;
  color: #8B98D4;
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
  color:#8B98D4;
  font-weight:bold;margin:0 0 6px;
}
.carousel-text p {
  font-size:15px;
  color:#666;
  margin:0;
}
:deep(.el-carousel__indicators){right:28px;bottom:20px;left:auto;}
:deep(.el-carousel__button){width:8px;height:8px;background:rgba(200,200,200,0.6);border-radius:50%;transition:0.2s;}
:deep(.el-carousel__button:hover){background:#8B98D4;}
:deep(.is-active .el-carousel__button){background:#8B98D4;}

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
  background-color: #F5F7FB; border-radius: 8px;
}
.data-item { flex: 1; text-align: center; }
.data-num { display: block; font-size: 24px; color: #8B98D4; font-weight: 600; }
.data-text { font-size: 12px; color: #666; }

.guide-section { margin: 0 0 20px; }
.guide-title { font-size: 16px; color: #333; margin: 0 0 8px; font-weight: 500; }
.guide-list { font-size: 13px; color: #666; padding-left: 20px; line-height: 1.8; }
.scene-tags { display: flex; flex-wrap: wrap; gap: 8px; }

.right-link { flex: 1; }

.link-header-new {
  font-size: 32px; font-weight: 600;
  background-image: linear-gradient(90deg, #8B98D4, #7C8AC7);
  background-clip: text;
  -webkit-background-clip: text;
  color: transparent;
  margin: 20px;
  padding-left: 10px;
}

.link-list { display: flex; flex-direction: column; gap: 12px; }
.link-card { 
  border-radius: 10px; 
  border: 1px solid #E1E5F2; 
  transition: all 0.3s ease; 
}
.link-card:hover {
  background: linear-gradient(90deg, #F5F7FB 0%, #F0F2FA 100%);
  border-color: #D1D7EC;
  transform: translateX(5px);
}

.link-btn {
  display: flex; align-items: center; justify-content: space-between;
  width: 100%; height: 100%; padding: 20px 24px;
  text-decoration: none; color: #333;
}
.link-icon {
  width: 44px; height: 44px; border-radius: 50%;
  background-color: #E1E5F2; display: flex;
  align-items: center; justify-content: center; margin-right: 16px;
}
.link-icon i { font-size: 22px; color: #8B98D4; }
.link-content { flex: 1; }
.link-row {
  display: flex;
  align-items: center;
  gap: 16px;
  flex-wrap: wrap;
}
.link-title {
  font-size: 18px;
  font-weight: bold;
  color: #8B98D4;
  margin: 0;
}
.link-desc {
  font-size: 13px;
  color: #666;
}
.link-arrow i { font-size: 16px; color: #8B98D4; opacity: 0.8; }

.bottom-recommend { margin-top: 20px; }
.recommend-card { 
  border-radius: 12px; 
  padding: 20px 24px; 
  border: 1px solid #E1E5F2; 
}
.recommend-title { font-size: 18px; color: #333; margin: 0 0 16px; font-weight: 500; }
.recommend-list { display: flex; flex-wrap: wrap; gap: 12px; }
.recommend-list a { color: #8B98D4; text-decoration: none; }
.recommend-list a:hover { color: #7C8AC7; text-decoration: underline; }

@media (max-width: 992px) {
  .main-content { flex-direction: column; }
  .left-intro { width: 100%; }
  .link-btn { padding: 16px; }
  .banner-title { font-size: 24px; }
  .link-header-new { font-size: 22px; }
}
</style>