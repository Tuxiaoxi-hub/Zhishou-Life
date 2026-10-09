import request from '@/utils/request'

// 查询食品辨别技巧列表
export function listIdentify(query) {
  return request({
    url: '/safety/identify/list',
    method: 'get',
    params: query
  })
}

// 查询食品辨别技巧详细
export function getIdentify(id) {
  return request({
    url: '/safety/identify/' + id,
    method: 'get'
  })
}

// 新增食品辨别技巧
export function addIdentify(data) {
  return request({
    url: '/safety/identify',
    method: 'post',
    data: data
  })
}

// 修改食品辨别技巧
export function updateIdentify(data) {
  return request({
    url: '/safety/identify',
    method: 'put',
    data: data
  })
}

// 删除食品辨别技巧
export function delIdentify(id) {
  return request({
    url: '/safety/identify/' + id,
    method: 'delete'
  })
}
