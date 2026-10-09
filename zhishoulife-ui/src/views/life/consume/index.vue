<template>
  <div class="app-container">
    <div class="header-spacing"></div>

    <div class="top-banner">
      <h1 class="banner-title">消费维权 · 实用知识指南</h1>
      <p class="banner-desc">维权渠道、纠纷处理、权益保护，让你消费安心、不踩坑</p>
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
            <img src="@/static/consume/1.jpg" alt="消费维权渠道" class="carousel-img">
            <div class="carousel-text">
              <h2>消费维权渠道</h2>
              <p>官方正规 · 投诉有门更高效</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/consume/2.jpg" alt="常见消费纠纷处理" class="carousel-img">
            <div class="carousel-text">
              <h2>消费纠纷处理</h2>
              <p>理性维权 · 合法保障自身权益</p>
            </div>
          </div>
        </el-carousel-item>
        <el-carousel-item>
          <div class="carousel-item">
            <img src="@/static/consume/3.jpg" alt="消费权益保护" class="carousel-img">
            <div class="carousel-text">
              <h2>消费权益保护</h2>
              <p>远离陷阱 · 安心消费不踩坑</p>
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
            消费维权模块整理官方正规维权渠道、常见消费纠纷处理流程、消费者合法权益保护知识，
            覆盖网购、食品、服务、虚假宣传等高频场景，帮你理性维权、合法维权。
          </p>

          <div class="data-card">
            <div class="data-item">
              <span class="data-num">40+</span>
              <span class="data-text">维权知识</span>
            </div>
            <div class="data-item">
              <span class="data-num">2</span>
              <span class="data-text">核心分类</span>
            </div>
            <div class="data-item">
              <span class="data-num">100%</span>
              <span class="data-text">官方权威</span>
            </div>
          </div>

          <div class="guide-section">
            <h4 class="guide-title">📌 使用指南</h4>
            <ul class="guide-list">
              <li>遇到消费问题可直接查看对应板块</li>
              <li>保存维权渠道，以备不时之需</li>
              <li>先协商、后投诉、依法维护自身权益</li>
            </ul>
          </div>

          <div class="scene-tags">
            <el-tag type="warning" effect="plain">维权渠道</el-tag>
            <el-tag type="warning" effect="plain">纠纷处理</el-tag>
            <el-tag type="warning" effect="plain">消费安全</el-tag>
          </div>
        </el-card>
      </div>

      <div class="right-link" style="display: flex; flex-direction: column; justify-content: center;">
        <h3 class="link-header-new">
          <i class="el-icon-menu" style="color:#fa8c16;margin-right:10px"></i>
          分类导航
        </h3>
        <div class="link-list">
          <el-card class="link-card" shadow="hover">
            <router-link to="/life/channel" class="link-btn">
              <div class="link-icon"><i class="el-icon-phone" /></div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">消费维权渠道</h4>
                  <span class="link-desc">12315、在线投诉、客服协商等官方正规渠道</span>
                </div>
              </div>
              <div class="link-arrow"><i class="el-icon-right"></i></div>
            </router-link>
          </el-card>

          <el-card class="link-card" shadow="hover">
            <router-link to="/life/dispute" class="link-btn">
              <div class="link-icon"><i class="el-icon-s-order" /></div>
              <div class="link-content">
                <div class="link-row">
                  <h4 class="link-title">常见消费纠纷处理</h4>
                  <span class="link-desc">网购退货、假货、虚假宣传、价格欺诈等处理方法</span>
                </div>
              </div>
              <div class="link-arrow"><i class="el-icon-right"></i></div>
            </router-link>
          </el-card>
        </div>

        <div class="bottom-recommend">
          <el-card class="recommend-card">
            <h3 class="recommend-title">🔥 热门推荐</h3>
            <div class="recommend-list">
              <el-tag type="warning" effect="plain">
                <a @click="$router.push('/life/channel')">12315投诉流程</a>
              </el-tag>
              <el-tag type="warning" effect="plain">
                <a @click="$router.push('/life/dispute')">网购假货怎么维权</a>
              </el-tag>
              <el-tag type="warning" effect="plain">
                <a @click="$router.push('/life/channel')">在线投诉平台入口</a>
              </el-tag>
            </div>
          </el-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default { name: "ConsumeIndex" }
</script>

<style scoped>
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
.data-text {font-size:13px;color:#666;margin-top:4px;white-space: nowrap;}

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