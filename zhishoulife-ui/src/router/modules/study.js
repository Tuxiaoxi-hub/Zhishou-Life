import Layout from '@/layout'

// 学习成长模块路由配置
const studyRouter = {
  path: '/study',
  component: Layout,
  redirect: '/study/cert/index',
  name: 'Study',
  meta: { title: '学习成长', icon: 'el-icon-book', permission: ['study:view'] },
  children: [
    // 二级菜单：考证考级
    {
      path: 'cert/index',
      component: () => import('@/views/study/cert/index'),
      name: 'StudyCert',
      meta: { title: '考证考级', icon: 'el-icon-certificate', permission: ['study:cert:view'] }
    },
    {
      path: 'profession',
      component: () => import('@/views/study/profession/index'),
      name: 'StudyCertProfession',
      meta: { title: '职业资格证书'}
    },
    {
      path: 'language',
      component: () => import('@/views/study/language/index'),
      name: 'StudyCertLanguage',
      meta: { title: '语言类证书'}
    },

    // 二级菜单：实用技能
    {
      path: 'skill/index',
      component: () => import('@/views/study/skill/index'),
      name: 'StudySkill',
      meta: { title: '实用技能', icon: 'el-icon-skill', permission: ['study:skill:view'] }
    },
    {
      path: 'office',
      component: () => import('@/views/study/office/index'),
      name: 'StudySkillOffice',
      meta: { title: '办公软件技能'}
    },
    {
      path: 'lifee',
      component: () => import('@/views/study/lifee/index'),
      name: 'StudySkillLife',
      meta: { title: '生活实用技能'}
    }
  ]
}

export default studyRouter