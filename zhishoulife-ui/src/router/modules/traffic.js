import Layout from '@/layout'

// 出行交通模块路由配置
const trafficRouter = {
  path: '/traffic',
  component: Layout,
  redirect: '/traffic/rule/index',
  name: 'Traffic',
  meta: { title: '出行交通', icon: 'el-icon-car', permission: ['traffic:view'] },
  children: [
    // 二级菜单：交通规则
    {
      path: 'rule/index',
      component: () => import('@/views/traffic/rule/index'),
      name: 'TrafficRule',
      meta: { title: '交通规则', icon: 'el-icon-traffic-light', permission: ['traffic:rule:view'] }
    },
    {
      path: 'sign',
      component: () => import('@/views/traffic/sign/index'),
      name: 'TrafficRuleSign',
      meta: { title: '交通标志识别'}
    },
    {
      path: 'common',
      component: () => import('@/views/traffic/common/index'),
      name: 'TrafficRuleCommon',
      meta: { title: '交通通行规则'}
    },

    // 二级菜单：出行安全
    {
      path: 'safe/index',
      component: () => import('@/views/traffic/safe/index'),
      name: 'TrafficSafe',
      meta: { title: '出行安全', icon: 'el-icon-safety', permission: ['traffic:safe:view'] }
    },
    {
      path: 'public',
      component: () => import('@/views/traffic/public/index'),
      name: 'TrafficSafePublic',
      meta: { title: '公共出行安全'}
    },
    {
      path: 'drive',
      component: () => import('@/views/traffic/drive/index'),
      name: 'TrafficSafeDrive',
      meta: { title: '自驾出行安全'}
    }
  ]
}

export default trafficRouter