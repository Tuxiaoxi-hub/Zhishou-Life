import request from '@/utils/request'

// 查询饮食禁忌与搭配列表
export function listTaboo(query) {
  return request({
    url: '/life/taboo/list',
    method: 'get',
    params: query
  })
}

// 查询饮食禁忌与搭配详细
export function getTaboo(id) {
  return request({
    url: '/life/taboo/' + id,
    method: 'get'
  })
}

// 新增饮食禁忌与搭配
export function addTaboo(data) {
  return request({
    url: '/life/taboo',
    method: 'post',
    data: data
  })
}

// 修改饮食禁忌与搭配
export function updateTaboo(data) {
  return request({
    url: '/life/taboo',
    method: 'put',
    data: data
  })
}

// 删除饮食禁忌与搭配
export function delTaboo(id) {
  return request({
    url: '/life/taboo/' + id,
    method: 'delete'
  })
}
