import request from '@/utils/request'

// 查询家常菜烹饪列表
export function listCook(query) {
  return request({
    url: '/life/cook/list',
    method: 'get',
    params: query
  })
}

// 查询家常菜烹饪详细
export function getCook(id) {
  return request({
    url: '/life/cook/' + id,
    method: 'get'
  })
}

// 新增家常菜烹饪
export function addCook(data) {
  return request({
    url: '/life/cook',
    method: 'post',
    data: data
  })
}

// 修改家常菜烹饪
export function updateCook(data) {
  return request({
    url: '/life/cook',
    method: 'put',
    data: data
  })
}

// 删除家常菜烹饪
export function delCook(id) {
  return request({
    url: '/life/cook/' + id,
    method: 'delete'
  })
}
