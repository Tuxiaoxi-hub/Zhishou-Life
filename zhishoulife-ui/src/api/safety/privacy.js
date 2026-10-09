import request from '@/utils/request'

// 查询个人隐私保护列表
export function listPrivacy(query) {
  return request({
    url: '/safety/privacy/list',
    method: 'get',
    params: query
  })
}

// 查询个人隐私保护详细
export function getPrivacy(id) {
  return request({
    url: '/safety/privacy/' + id,
    method: 'get'
  })
}

// 新增个人隐私保护
export function addPrivacy(data) {
  return request({
    url: '/safety/privacy',
    method: 'post',
    data: data
  })
}

// 修改个人隐私保护
export function updatePrivacy(data) {
  return request({
    url: '/safety/privacy',
    method: 'put',
    data: data
  })
}

// 删除个人隐私保护
export function delPrivacy(id) {
  return request({
    url: '/safety/privacy/' + id,
    method: 'delete'
  })
}
