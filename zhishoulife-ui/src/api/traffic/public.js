import request from '@/utils/request'

// 查询公共出行安全列表
export function listPublic(query) {
  return request({
    url: '/traffic/public/list',
    method: 'get',
    params: query
  })
}

// 查询公共出行安全详细
export function getPublic(id) {
  return request({
    url: '/traffic/public/' + id,
    method: 'get'
  })
}

// 新增公共出行安全
export function addPublic(data) {
  return request({
    url: '/traffic/public',
    method: 'post',
    data: data
  })
}

// 修改公共出行安全
export function updatePublic(data) {
  return request({
    url: '/traffic/public',
    method: 'put',
    data: data
  })
}

// 删除公共出行安全
export function delPublic(id) {
  return request({
    url: '/traffic/public/' + id,
    method: 'delete'
  })
}
