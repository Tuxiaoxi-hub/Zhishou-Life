import Layout from '@/layout'

// 居家实用模块路由配置
const homeRouter = {
  path: '/home',
  component: Layout,
  redirect: '/home/storagee/index',
  name: 'Home',
  meta: { title: '居家实用', icon: 'el-icon-home', permission: ['home:view'] },
  children: [
    // 二级菜单：家居收纳
    {
      path: 'storagee/index',
      component: () => import('@/views/home/storagee/index'),
      name: 'HomeStorage',
      meta: { title: '家居收纳', icon: 'el-icon-box', permission: ['home:storagee:view'] }
    },
    {
      path: 'space',
      component: () => import('@/views/home/space/index'),
      name: 'HomeStorageSpace',
      meta: { title: '空间收纳技巧'}
    },
    {
      path: 'goods',
      component: () => import('@/views/home/goods/index'),
      name: 'HomeStorageGoods',
      meta: { title: '物品收纳整理'}
    },

    // 二级菜单：家电使用
    {
      path: 'appliance/index',
      component: () => import('@/views/home/appliance/index'),
      name: 'HomeAppliance',
      meta: { title: '家电使用', icon: 'el-icon-s-tools', permission: ['home:appliance:view'] }
    },
    {
      path: 'use',
      component: () => import('@/views/home/use/index'),
      name: 'HomeApplianceUse',
      meta: { title: '家电操作技巧'}
    },
    {
      path: 'maintain',
      component: () => import('@/views/home/maintain/index'),
      name: 'HomeApplianceMaintain',
      meta: { title: '家电保养维护'}
    }
  ]
}

export default homeRouter