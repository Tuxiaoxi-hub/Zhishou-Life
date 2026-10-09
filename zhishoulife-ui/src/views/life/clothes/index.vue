<template>
  <div class="app-container">
    <div class="header-spacing"></div>

    <div class="top-banner">
      <h1 class="banner-title">衣物护理 · 实用知识指南</h1>
      <p class="banner-desc">精选清洗、去渍、收纳三大板块，让衣物干净如新、长久耐用</p>
    </div>

    <!-- 轮播：复原原版 + 文字配色+位置微调 -->
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
            <img src="@/static/clothes/1.jpg" alt="衣物清洗保养" class="carousel-img">
            <div class="carousel-text">
              <h2>衣物清洗保养</h2>
              <p>专业护色 · 延长衣物寿命</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/clothes/2.jpg" alt="污渍去除技巧" class="carousel-img">
            <div class="carousel-text">
              <h2>污渍去除技巧</h2>
              <p>轻松处理各类顽固污渍</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/clothes/3.jpg" alt="衣物收纳整理" class="carousel-img">
            <div class="carousel-text">
              <h2>衣物收纳整理</h2>
              <p>防潮防虫 · 空间最大化</p>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="main-content">
      <!-- 左侧模块简介：数据块居中规整，不乱 -->
      <div class="left-intro">
        <el-card shadow="hover" class="intro-card">
          <h3 class="intro-title">👕 模块简介</h3>
          <p class="intro-content">
            衣物护理模块提供科学清洗方式、各类污渍去除技巧、换季收纳方案，适用于棉、麻、丝、毛、化纤等多种面料，
            内容简单实用，居家即可操作，延长衣物寿命，保持整洁美观。
          </p>

          <!-- 修复：28+ /3核心 /100% 全部居中对齐、字体协调 -->
          <div class="data-card">
            <div class="data-item">
              <span class="data-num">50+</span>
              <span class="data-text">实用技巧</span>
            </div>
            <div class="data-item">
              <span class="data-num">3</span>
              <span class="data-text">核心分类</span>
            </div>
            <div class="data-item">
              <span class="data-num">100%</span>
              <span class="data-text">居家可用</span>
            </div>
          </div>

          <div class="guide-section">
            <h4 class="guide-title">📌 使用指南</h4>
            <ul class="guide-list">
              <li>点击右侧分类查看详细方法</li>
              <li>按面料类型、污渍种类快速查找</li>
              <li>所有方法安全不伤衣</li>
            </ul>
          </div>

          <div class="scene-tags">
            <el-tag type="warning" effect="plain">衣物清洗</el-tag>
            <el-tag type="warning" effect="plain">污渍去除</el-tag>
            <el-tag type="warning" effect="plain">衣物收纳</el-tag>
          </div>
        </el-card>
      </div>

      <!-- 右侧分类导航：大标题统一橘色，原版样式不动 -->
      <div class="right-link">
        <h3 class="link-header-new">
          <i class="el-icon-menu" style="color:#fa8c16;margin-right:10px"></i>
          分类导航
        </h3>
        <div class="link-list">
          <el-card class="link-card" shadow="hover">
            <router-link to="/life/clean" class="link-btn">
              <div class="link-icon"><i class="el-icon-washing-machine" /></div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">衣物清洗保养</h4>
                  <span class="link-desc">不同面料正确清洗、脱水、晾晒、护色方法</span>
                </div>
              </div>
              <div class="link-arrow"><i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>
          <el-card class="link-card" shadow="hover">
            <router-link to="/life/stain" class="link-btn">
              <div class="link-icon"><i class="el-icon-delete" /></div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">污渍去除技巧</h4>
                  <span class="link-desc">油渍、汗渍、笔印、血渍等顽固污渍处理</span>
                </div>
              </div>
              <div class="link-arrow"><i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>
          <el-card class="link-card" shadow="hover">
            <router-link to="/life/storageee" class="link-btn">
              <div class="link-icon"><i class="el-icon-box" /></div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">衣物收纳整理</h4>
                  <span class="link-desc">衣柜空间优化、换季衣物防潮、防虫收纳</span>
                </div>
              </div>
              <div class="link-arrow"><i class="el-icon-right"></i>
              </div>
            </router-link>
          </el-card>
        </div>

        <!-- 热门推荐：原版文字保留，仅压高度 -->
        <div class="bottom-recommend">
          <el-card class="recommend-card">
            <h3 class="recommend-title">🔥 热门推荐</h3>
            <div class="recommend-list">
              <el-tag type="warning" effect="plain">
                <a @click="$router.push('/life/clean')">纯棉衣物清洗护色</a>
              </el-tag>
              <el-tag type="warning" effect="plain">
                <a @click="$router.push('/life/stain')">油渍快速去除方法</a>
              </el-tag>
              <el-tag type="warning" effect="plain">
                <a @click="$router.push('/life/storageee')">换季衣物收纳技巧</a>
              </el-tag>
            </div>
          </el-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default { name: "ClothesIndex" }
</script>

<style scoped>
/* 基础留白 */
.header-spacing {height: 30px;}
.app-container {background:#fff;padding:0 20px 30px;}

.top-banner {
  background:linear-gradient(90deg, #FFF5E6 0%, #FFEFD2 100%);
  border-radius:16px;padding:20px;margin:0 0 20px;text-align:center;
}
.banner-title {font-size:24px;color:#FA8C16;margin:0 0 8px;font-weight:600;}
.banner-desc {font-size:15px;color:#666;margin:0;}

/* 轮播核心修复：文字位置右移、配色+小圆点hover橘色 */
.carousel-box {border-radius:14px;overflow:hidden;margin:0 0 24px;}
.carousel-item {width:100%;height:220px;position:relative;}
.carousel-img {width:100%;height:100%;object-fit:cover;}
/* 文字往右挪，不贴图片边缘 */
.carousel-text {
  position: absolute;
  left: 48px;  /* 右移，不贴边 */
  top: 50%;
  transform: translateY(-50%);
}
.carousel-text h2 {
  font-size:26px;
  color:#FA8C16; /* 大标题橘色 */
  font-weight:bold;margin:0 0 6px;
}
.carousel-text p {
  font-size:15px;
  color:#ffffff; /* 副标题白色 */
  margin:0;
}

/* 轮播小圆点：默认浅灰，选中/hover变橘色 */
:deep(.el-carousel__indicators){right:28px!important;bottom:20px!important;left:auto!important;}
:deep(.el-carousel__button){width:8px;height:8px;background:rgba(200,200,200,0.6);border-radius:50%;transition:0.2s;}
:deep(.el-carousel__button:hover){background:#FA8C16;}
:deep(.is-active .el-carousel__button){background:#FA8C16;}

/* 主体布局 */
.main-content {display:flex;gap:24px;}
.left-intro {width:26%;}

/* 模块简介：间距拉开，数据块居中规整 */
.intro-card {border-radius:12px;padding:36px;height:100%;}
.intro-title {font-size:20px;color:#333;margin:0 0 30px;}
.intro-content {font-size:14px;color:#666;line-height:1.8;margin:0 0 40px;}

/* 修复28+数据块：统一居中、字体协调不杂乱 */
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

/* 导航标题保持原版橘色 */
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

/* 热门推荐原版不变 */
.recommend-card {border-radius:12px;padding:16px 24px;border:1px solid #FFE0B2;}
.recommend-title {font-size:18px;color:#333;margin:0 0 12px;}
.recommend-list {display:flex;flex-wrap:wrap;gap:12px;}
.recommend-list a {color:#FA8C16;text-decoration:none;}

@media (max-width:992px){
  .main-content{flex-direction:column;}
  .left-intro{width:100%;}
}
</style>