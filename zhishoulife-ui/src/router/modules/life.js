import Layout from '@/layout'

const lifeRouter = {
  path: '/life',
  component: Layout,
  redirect: '/life/food/index',
  name: 'Life',
  meta: { title: '日常生活', icon: 'el-icon-house' },
  children: [
    {
      path: 'food/index',
      component: () => import('@/views/life/food/index'),
      name: 'LifeFood',
      meta: { title: '饮食美食', icon: 'el-icon-food', permission: ['life:food:view'] }
    },
    {
      path: 'select',
      component: () => import('@/views/life/select/index'),
      name: 'LifeFoodSelect',
      meta: { title: '食材挑选与保存'}
    },
    {
      path: 'cook',
      component: () => import('@/views/life/cook/index'),
      name: 'LifeFoodCook',
      meta: { title: '家常菜烹饪'}
    },
    {
      path: 'taboo',
      component: () => import('@/views/life/taboo/index'),
      name: 'LifeFoodTaboo',
      meta: { title: '饮食禁忌与搭配'}
    },
    {
      path: 'clothes/index',
      component: () => import('@/views/life/clothes/index'),
      name: 'LifeClothes',
      meta: { title: '衣物护理', icon: 'el-icon-shirt', permission: ['life:clothes:view'] }
    },
    {
      path: 'clean',
      component: () => import('@/views/life/clean/index'),
      name: 'LifeClothesClean',
      meta: { title: '衣物清洗保养'}
    },
    {
      path: 'stain',
      component: () => import('@/views/life/stain/index'),
      name: 'LifeClothesStain',
      meta: { title: '污渍去除技巧'}
    },
    {
      path: 'storageee',
      component: () => import('@/views/life/storageee/index'),
      name: 'LifeClothesStorage',
      meta: { title: '衣物收纳整理'}
    },
    {
      path: 'consume/index',
      component: () => import('@/views/life/consume/index'),
      name: 'LifeConsume',
      meta: { title: '消费维权', icon: 'el-icon-shield', permission: ['life:consume:view'] }
    },
    {
      path: 'channel',
      component: () => import('@/views/life/channel/index'),
      name: 'LifeConsumeChannel',
      meta: { title: '消费维权渠道'}
    },
    {
      path: 'dispute',
      component: () => import('@/views/life/dispute/index'),
      name: 'LifeConsumeDispute',
      meta: { title: '常见消费纠纷处理'}
    }
  ]
}

export default lifeRouter