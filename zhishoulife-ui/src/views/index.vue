<template>
  <div class="brand-container" id="zhihu-life-home">
    <!-- 欢迎横幅 -->
    <div class="welcome-banner" :class="{'slide-in': isLoaded}">
      <div class="banner-content">
        <h1 class="welcome-title">欢迎进入知守生活</h1>
        <p class="welcome-subtitle">一站式生活知识普及服务平台，让生活更有温度</p>
        <div class="welcome-buttons">
          <el-button type="primary" size="large" @click="goToDashboard">
            进入系统 <i class="el-icon-arrow-right"></i>
          </el-button>
          <el-button size="large" @click="scrollToGuide">
            功能指南 <i class="el-icon-arrow-down"></i>
          </el-button>
        </div>
      </div>
    </div>

    <!-- 系统概述 -->
    <el-row :gutter="30" class="system-intro">
      <el-col :sm="24" :md="24" :lg="24">
        <el-card shadow="hover" class="intro-card">
          <template #header>
            <div class="card-header">
              <i class="el-icon-s-home"></i> 系统概述
            </div>
          </template>
          <div class="card-content">
            <p class="intro-desc">
              知守生活是一款专注于生活知识普及的综合性服务平台，平台整合全品类实用生活干货，
              以清晰的分类体系为用户提供精准的知识查询服务，同时搭配智能助手小智，
              实现场景化知识引导，让每个人都能轻松获取生活技巧，提升生活品质。
            </p>
            <div class="core-modules">
              <div class="module-item" v-for="(module, index) in coreModules" :key="index">
                <div class="module-title">
                  <i :class="module.icon"></i> {{ module.name }}
                </div>
                <div class="module-sub">{{ module.subList.join(' / ') }}</div>
              </div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- ====================== 热门知识推荐（左右双栏 + 每条带互动语） ====================== -->
    <el-row :gutter="30" class="knowledge-recommend">
      <el-col :sm="24" :md="24" :lg="24">
        <el-card shadow="hover" class="intro-card">
          <template #header>
            <div class="card-header">
              <i class="el-icon-s-mark"></i> 热门知识推荐
            </div>
          </template>
          <div class="card-content">
            <p class="intro-desc">
              每日一个生活小技巧，日积月累增长见识，提升生活素养。平台汇聚饮食、安全、出行、健康等全领域实用内容，
              点击即可快速学习，让科学知识融入日常，让生活更安心、更健康、更有品质。
            </p>

            <!-- 左右双栏布局 → 不再一长条，更美观 -->
            <div class="knowledge-two-col">
              <!-- 左栏 -->
              <div class="col-left">
                <div class="knowledge-item" @click="$router.push('/life/select')">
                  <div class="title">新鲜菠菜的挑选技巧</div>
                  <div class="tip">学会挑选，营养更足，口感更佳～</div>
                </div>
                <div class="knowledge-item" @click="$router.push('/life/cook')">
                  <div class="title">番茄炒蛋简易教程</div>
                  <div class="tip">家常快手菜，零失败超下饭～</div>
                </div>
                <div class="knowledge-item" @click="$router.push('/safety/identify')">
                  <div class="title">地沟油辨别方法</div>
                  <div class="tip">远离劣质油，守护饮食安全～</div>
                </div>
                <div class="knowledge-item" @click="$router.push('/safety/fraud')">
                  <div class="title">电信诈骗防范技巧</div>
                  <div class="tip">提高警惕，守护财产安全～</div>
                </div>
                <div class="knowledge-item" @click="$router.push('/traffic/public')">
                  <div class="title">网约车乘车安全指南</div>
                  <div class="tip">平安出行，时刻保护自己～</div>
                </div>
                <div class="knowledge-item" @click="$router.push('/safety/electric')">
                  <div class="title">燃气泄漏应急处理</div>
                  <div class="tip">正确处置，远离危险，守护家人安全～</div>
                </div>
              </div>

              <!-- 右栏 -->
              <div class="col-right">
                <div class="knowledge-item" @click="$router.push('/study/office')">
                  <div class="title">Word基础排版技巧</div>
                  <div class="tip">轻松排版，文档更专业～</div>
                </div>
                <div class="knowledge-item" @click="$router.push('/study/office')">
                  <div class="title">PPT一键美化方法</div>
                  <div class="tip">颜值提升，汇报更出彩～</div>
                </div>
                <div class="knowledge-item" @click="$router.push('/study/profession')">
                  <div class="title">教师资格证备考指南</div>
                  <div class="tip">高效备考，拿证更轻松～</div>
                </div>
                <div class="knowledge-item" @click="$router.push('/home/space')">
                  <div class="title">卫生间浴室柜收纳</div>
                  <div class="tip">整洁有序，空间大一倍～</div>
                </div>
                <div class="knowledge-item" @click="$router.push('/home/space')">
                  <div class="title">厨房抽屉收纳方法</div>
                  <div class="tip">分类清晰，做饭更省心～</div>
                </div>
                <div class="knowledge-item" @click="$router.push('/home/maintain')">
                  <div class="title">冰箱除霜保养技巧</div>
                  <div class="tip">保养到位，保鲜更长久～</div>
                </div>
              </div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 功能指南 -->
    <el-row :gutter="30" class="function-guide" id="functionGuide">
      <el-col :sm="24" :md="24" :lg="24">
        <el-card shadow="hover" class="intro-card">
          <template #header>
            <div class="card-header">
              <i class="el-icon-s-guide"></i> 功能指南
            </div>
          </template>
          <div class="card-content">
            <p class="intro-desc">
              知守生活平台围绕各类生活场景打造全维度知识服务，同时搭载智能助手小智，
              支持自然语言交互查询，精准匹配生活知识内容，为你解决生活中的各类小问题。
            </p>
            <div class="core-modules">
              <div class="module-item">
                <div class="module-title">
                  <i class="el-icon-s-service"></i> 核心知识服务
                </div>
                <div class="module-sub">覆盖日常生活六大核心板块，提供食材挑选、家常菜烹饪、养生常识、安全防护、出行指南、实用技能等全品类生活干货，所有知识按分类清晰索引，随查随用。</div>
              </div>
              <div class="module-item">
                <div class="module-title">
                  <i class="el-icon-s-comment"></i> 智能助手使用
                </div>
                <div class="module-sub">直接输入生活问题即可查询，如「番茄炒蛋怎么做」「羊毛衫怎么防缩水」，助手会精准匹配对应知识并给出层级索引，闲聊时也会贴心引导至相关生活知识内容。</div>
              </div>
              <div class="module-item">
                <div class="module-title">
                  <i class="el-icon-s-light"></i> 场景化贴心引导
                </div>
                <div class="module-sub">情绪不佳、想减肥、闲暇无事等无明确查询需求时，助手会先温柔回应，再引导至四季养生、运动健身、生活技能等相关板块，为你推荐实用生活知识。</div>
              </div>
              <div class="module-item">
                <div class="module-title">
                  <i class="el-icon-s-search"></i> 精准分类索引
                </div>
                <div class="module-sub">所有生活知识按「大类>二级分类>三级分类>具体内容」层级索引，查询结果清晰展示内容归属，方便你快速定位同类相关知识，一站式获取解决方案。</div>
              </div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 最近更新 -->
    <el-row :gutter="30" class="recent-updates">
      <el-col :sm="24" :lg="24">
        <el-card shadow="hover" class="update-card">
          <template #header>
            <div class="card-header">
              <i class="el-icon-s-refresh-right"></i> 最近更新
            </div>
          </template>
          <div class="update-list">
            <div v-for="update in recentUpdates" :key="update.version" class="update-item">
              <div class="update-header">
                <span class="update-version">{{ update.version }}</span>
                <span class="update-date">{{ update.date }}</span>
              </div>
              <div class="update-content">
                <ul>
                  <li v-for="item in update.items" :key="item" class="update-item-content">{{ item }}</li>
                </ul>
              </div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 版权信息 -->
    <el-row :gutter="30" class="contact-info">
      <el-col :sm="24" :lg="24">
        <el-card shadow="hover" class="contact-card">
          <template #header>
            <div class="card-header">
              <i class="el-icon-s-claim"></i> 版权归属
            </div>
          </template>
          <div class="contact-content">
            <div class="contact-item">
              <i class="el-icon-s-copyright"></i>
              <span>版权所有 © 2026 知守生活平台</span>
            </div>
            <div class="contact-item">
              <i class="el-icon-s-school"></i>
              <span>技术支持：长治学院计算机系</span>
            </div>
            <div class="contact-item">
              <i class="el-icon-s-email"></i>
              <span>邮箱：<input type="text" placeholder="www.07411@outlook.com" style="border:none; outline:none; background:transparent; color: #000;" /></span>
            </div>
            <div class="contact-item">
              <i class="el-icon-s-phone"></i>
              <span>联系方式：<input type="text" placeholder="17836085089" style="border:none; outline:none; background:transparent; color:#000;" /></span>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

const isLoaded = ref(false)
const version = ref('1.0.0')

const coreModules = ref([
  { name: '日常生活', icon: 'el-icon-s-home', subList: ['饮食美食', '衣物护理', '消费维权'] },
  { name: '健康医疗', icon: 'el-icon-s-health', subList: ['基础健康', '医疗常识', '急救护理'] },
  { name: '安全防护', icon: 'el-icon-s-shield', subList: ['食品安全', '网络安全', '居家安全'] },
  { name: '出行交通', icon: 'el-icon-s-taxi', subList: ['交通规则常识', '出行安全'] },
  { name: '学习成长', icon: 'el-icon-s-book', subList: ['考证考级', '实用技能学习'] },
  { name: '居家实用', icon: 'el-icon-s-tools', subList: ['家居收纳', '家电使用'] }
])

const recentUpdates = ref([
  {
    version: 'v1.0.0',
    date: '2026-03-21',
    items: [
      "知守生活平台正式发布",
      "完成六大核心生活知识板块搭建与内容上线",
      "上线智能助手小智，支持生活知识精准查询与场景化引导",
      "实现生活知识分类索引与快捷查询功能"
    ]
  }
])

function goToDashboard() {
  console.log('跳转到系统首页')
}
function scrollToGuide() {
  const guideDom = document.getElementById('functionGuide')
  if (guideDom) {
    guideDom.scrollIntoView({ behavior: 'smooth', block: 'start' })
    window.scrollBy(0, -20)
  }
}

onMounted(() => {
  isLoaded.value = true
})
</script>

<style scoped lang="scss">
.brand-container {
  padding: 20px;
  scroll-behavior: smooth;
  
  .welcome-banner {
    position: relative;
    height: 300px;
    border-radius: 12px;
    background: linear-gradient(135deg, #4285f4, #34a853);
    margin-bottom: 30px;
    overflow: hidden;
    
    &::before {
      content: '';
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background: url('@/assets/images/brand-bg.jpg') no-repeat center;
      background-size: cover;
      opacity: 0.2;
    }
    
    .banner-content {
      position: relative;
      z-index: 1;
      height: 100%;
      display: flex;
      flex-direction: column;
      justify-content: center;
      padding: 0 40px;
      color: white;
      
      .welcome-title {
        font-size: 36px;
        font-weight: 700;
        margin-bottom: 15px;
        text-shadow: 0 2px 4px rgba(0,0,0,0.1);
        animation: fadeInUp 1s ease-out;
        
        &::after {
          content: '';
          display: block;
          width: 60px;
          height: 3px;
          background: white;
          margin-top: 15px;
          border-radius: 3px;
        }
      }
      
      .welcome-subtitle {
        font-size: 18px;
        margin-bottom: 30px;
        max-width: 600px;
        animation: fadeInUp 1s ease-out 0.2s both;
      }
      
      .welcome-buttons {
        animation: fadeInUp 1s ease-out 0.4s both;
        
        .el-button {
          margin-right: 15px;
          padding: 12px 30px;
          font-size: 16px;
          
          &:first-of-type {
            background-color: white;
            color: #4285f4;
            font-weight: 500;
            
            &:hover {
              background-color: #f0f5ff;
            }
          }
        }
      }
    }
  }

  // 系统概述 + 功能指南 + 推荐板块 通用样式
  .system-intro, .function-guide, .knowledge-recommend {
    margin-bottom: 30px;
    
    .intro-card {
      height: 100%;
      
      .card-header {
        display: flex;
        align-items: center;
        font-size: 18px;
        font-weight: 500;
        
        i {
          margin-right: 10px;
          font-size: 20px;
          color: #4285f4;
        }
      }
      
      .card-content {
        padding: 20px 0;
        
        .intro-desc {
          line-height: 1.8;
          font-size: 15px;
          color: #333;
          margin-bottom: 25px;
          text-align: justify;
        }

        // 原有网格
        .core-modules {
          display: grid;
          grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
          gap: 20px;
        }

        // ====================== 双栏布局 ======================
        .knowledge-two-col {
          display: flex;
          gap: 20px;
          
          .col-left, .col-right {
            flex: 1;
            display: flex;
            flex-direction: column;
            gap: 12px;
          }
        }

        // 每条知识卡片（标题 + 互动语）
        .knowledge-item {
          padding: 16px 20px;
          border: 1px solid #eaeef5;
          border-radius: 8px;
          cursor: pointer;
          transition: all 0.3s;

          .title {
            font-size: 15px;
            font-weight: 500;
            color: #333;
            margin-bottom: 6px;
          }
          .tip {
            font-size: 13px;
            color: #666;
          }

          &:hover {
            border-color: #4285f4;
            background: #f8faff;
            transform: translateX(4px);
          }
        }
        
        .module-item {
          padding: 18px 20px;
          border: 1px solid #eaeef5;
          border-radius: 10px;
          transition: all 0.3s ease;
          
          &:hover {
            border-color: #4285f4;
            box-shadow: 0 4px 12px rgba(66, 133, 244, 0.1);
            transform: translateY(-2px);
          }
          
          .module-title {
            display: flex;
            align-items: center;
            font-size: 16px;
            font-weight: 600;
            color: #2f3439;
            margin-bottom: 8px;
            
            i {
              font-size: 18px;
              color: #4285f4;
              margin-right: 10px;
            }
          }
          
          .module-sub {
            font-size: 14px;
            color: #666;
            line-height: 1.7;
            word-break: break-all;
          }
        }
      }
    }
  }
  
  .recent-updates {
    margin-bottom: 30px;
    
    .update-card {
      .update-list {
        .update-item {
          padding: 20px 0;
          border-bottom: 1px solid #f0f2f5;
          
          &:last-child {
            border-bottom: none;
          }
          
          .update-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
            
            .update-version {
              font-size: 18px;
              font-weight: 600;
              color: #4285f4;
            }
            
            .update-date {
              font-size: 14px;
              color: #909399;
            }
          }
          
          .update-content {
            padding-left: 15px;
            
            ul {
              li {
                margin-bottom: 8px;
                position: relative;
                list-style-type: none;
                
                &::before {
                  content: '✓';
                  position: absolute;
                  left: -15px;
                  color: #34a853;
                }
              }
            }
          }
        }
      }
    }
  }
  
  .contact-info {
    .contact-card {
      .contact-content {
        .contact-item {
          display: flex;
          align-items: center;
          padding: 12px 0;
          font-size: 16px;
          
          i {
            margin-right: 15px;
            width: 30px;
            color: #4285f4;
          }
          
          input {
            width: 200px;
            color: #4285f4;
            font-size: 16px;
            &::placeholder {
              color: #909399;
            }
          }
        }
      }
    }
  }
}

@keyframes fadeInUp {
  from { opacity: 0; transform: translateY(20px); }
  to { opacity: 1; transform: translateY(0); }
}
.slide-in { animation: slideIn 0.5s ease-out; }
@keyframes slideIn {
  from { transform: translateY(-20px); opacity: 0; }
  to { transform: translateY(0); opacity: 1; }
}
* { scroll-behavior: smooth; }
</style>