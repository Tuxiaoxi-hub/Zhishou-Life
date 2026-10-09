import request from '@/utils/request'

// 查询物品收纳整理列表
export function listGoods(query) {
  return request({
    url: '/home/goods/list',
    method: 'get',
    params: query
  })
}

// 查询物品收纳整理详细
export function getGoods(id) {
  return request({
    url: '/home/goods/' + id,
    method: 'get'
  })
}

// 新增物品收纳整理
export function addGoods(data) {
  return request({
    url: '/home/goods',
    method: 'post',
    data: data
  })
}

// 修改物品收纳整理
export function updateGoods(data) {
  return request({
    url: '/home/goods',
    method: 'put',
    data: data
  })
}

// 删除物品收纳整理
export function delGoods(id) {
  return request({
    url: '/home/goods/' + id,
    method: 'delete'
  })
}
