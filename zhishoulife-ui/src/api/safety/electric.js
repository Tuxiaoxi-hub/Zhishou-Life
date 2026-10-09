import request from '@/utils/request'

// 查询用火用电安全列表
export function listElectric(query) {
  return request({
    url: '/safety/electric/list',
    method: 'get',
    params: query
  })
}

// 查询用火用电安全详细
export function getElectric(id) {
  return request({
    url: '/safety/electric/' + id,
    method: 'get'
  })
}

// 新增用火用电安全
export function addElectric(data) {
  return request({
    url: '/safety/electric',
    method: 'post',
    data: data
  })
}

// 修改用火用电安全
export function updateElectric(data) {
  return request({
    url: '/safety/electric',
    method: 'put',
    data: data
  })
}

// 删除用火用电安全
export function delElectric(id) {
  return request({
    url: '/safety/electric/' + id,
    method: 'delete'
  })
}
