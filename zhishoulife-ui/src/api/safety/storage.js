import request from '@/utils/request'

// 查询食品储存安全列表
export function listStorage(query) {
  return request({
    url: '/safety/storage/list',
    method: 'get',
    params: query
  })
}

// 查询食品储存安全详细
export function getStorage(id) {
  return request({
    url: '/safety/storage/' + id,
    method: 'get'
  })
}

// 新增食品储存安全
export function addStorage(data) {
  return request({
    url: '/safety/storage',
    method: 'post',
    data: data
  })
}

// 修改食品储存安全
export function updateStorage(data) {
  return request({
    url: '/safety/storage',
    method: 'put',
    data: data
  })
}

// 删除食品储存安全
export function delStorage(id) {
  return request({
    url: '/safety/storage/' + id,
    method: 'delete'
  })
}
