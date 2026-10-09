import Layout from '@/layout'

// 安全防护模块路由配置
const safetyRouter = {
  path: '/safety',
  component: Layout,
  redirect: '/safety/foodsafe/index',
  name: 'Safety',
  meta: { title: '安全防护', icon: 'el-icon-shield', permission: ['safety:view'] },
  children: [
    // 二级菜单：食品安全
    {
      path: 'foodsafe/index',
      component: () => import('@/views/safety/foodsafe/index'),
      name: 'SafetyFoodsafe',
      meta: { title: '食品安全', icon: 'el-icon-food-safe', permission: ['safety:foodsafe:view'] }
    },
    // 改成二级
    {
      path: 'identify',
      component: () => import('@/views/safety/identify/index'),
      name: 'SafetyFoodsafeIdentify',
      meta: { title: '食品辨别技巧'}
    },
    {
      path: 'storage',
      component: () => import('@/views/safety/storage/index'),
      name: 'SafetyFoodsafeStorage',
      meta: { title: '食品储存安全'}
    },
    {
      path: 'takeaway',
      component: () => import('@/views/safety/takeaway/index'),
      name: 'SafetyFoodsafeTakeaway',
      meta: { title: '外卖安全常识'}
    },

    // 二级菜单：网络安全
    {
      path: 'network/index',
      component: () => import('@/views/safety/network/index'),
      name: 'SafetyNetwork',
      meta: { title: '网络安全', icon: 'el-icon-wifi', permission: ['safety:network:view'] }
    },
    // 改成二级
    {
      path: 'fraud',
      component: () => import('@/views/safety/fraud/index'),
      name: 'SafetyNetworkFraud',
      meta: { title: '网络诈骗防范'}
    },
    {
      path: 'privacy',
      component: () => import('@/views/safety/privacy/index'),
      name: 'SafetyNetworkPrivacy',
      meta: { title: '个人隐私保护'}
    },
    {
      path: 'account',
      component: () => import('@/views/safety/account/index'),
      name: 'SafetyNetworkAccount',
      meta: { title: '账号安全防护'}
    },

    // 二级菜单：居家安全
    {
      path: 'homesafe/index',
      component: () => import('@/views/safety/homesafe/index'),
      name: 'SafetyHomesafe',
      meta: { title: '居家安全', icon: 'el-icon-lock', permission: ['safety:homesafe:view'] }
    },
    // 改成二级
    {
      path: 'electric',
      component: () => import('@/views/safety/electric/index'),
      name: 'SafetyHomesafeFire',
      meta: { title: '用火用电安全'}
    },
    {
      path: 'theft',
      component: () => import('@/views/safety/theft/index'),
      name: 'SafetyHomesafeTheft',
      meta: { title: '防盗防入侵'}
    }
  ]
}

export default safetyRouter