import Layout from '@/layout'

const healthRouter = {
  path: '/health',
  component: Layout,
  redirect: '/health/basic/index',
  name: 'Health',
  meta: { title: '健康医疗', icon: 'el-icon-medical-icon' },
  children: [
    {
      path: 'basic/index',
      component: () => import('@/views/health/basic/index'),
      name: 'HealthBasic',
      meta: { title: '基础健康', icon: 'el-icon-user', permission: ['health:basic:view'] }
    },
    {
      path: 'nursing',
      component: () => import('@/views/health/nursing/index'),
      name: 'HealthBasicNursing',
      meta: { title: '常见病症护理'}
    },
    {
      path: 'season',
      component: () => import('@/views/health/season/index'),
      name: 'HealthBasicSeason',
      meta: { title: '四季养生常识'}
    },
    {
      path: 'sport',
      component: () => import('@/views/health/sport/index'),
      name: 'HealthBasicSport',
      meta: { title: '运动健身常识'}
    },

    {
      path: 'medical/index',
      component: () => import('@/views/health/medical/index'),
      name: 'HealthMedical',
      meta: { title: '医疗常识', icon: 'el-icon-hospital', permission: ['health:medical:view'] }
    },
    {
      path: 'drug',
      component: () => import('@/views/health/drug/index'),
      name: 'HealthMedicalDrug',
      meta: { title: '药物安全'}
    },
    {
      path: 'process',
      component: () => import('@/views/health/process/index'),
      name: 'HealthMedicalProcess',
      meta: { title: '就医流程指南'}
    },
    {
      path: 'checkup',
      component: () => import('@/views/health/checkup/index'),
      name: 'HealthMedicalCheckup',
      meta: { title: '体检知识科普'}
    },

    {
      path: 'firstaid/index',
      component: () => import('@/views/health/firstaid/index'),
      name: 'HealthFirstaid',
      meta: { title: '急救护理', icon: 'el-icon-alarm-clock', permission: ['health:firstaid:view'] }
    },
    {
      path: 'method',
      component: () => import('@/views/health/method/index'),
      name: 'HealthFirstaidMethod',
      meta: { title: '常见急救方法'}
    },
    {
      path: 'trauma',
      component: () => import('@/views/health/trauma/index'),
      name: 'HealthFirstaidTrauma',
      meta: { title: '外伤应急处理'}
    }
  ]
}

export default healthRouter