import request from '@/utils/request'

// 查询常见急救方法列表
export function listAid(query) {
  return request({
    url: '/health/aid/list',
    method: 'get',
    params: query
  })
}

// 查询常见急救方法详细
export function getAid(id) {
  return request({
    url: '/health/aid/' + id,
    method: 'get'
  })
}

// 新增常见急救方法
export function addAid(data) {
  return request({
    url: '/health/aid',
    method: 'post',
    data: data
  })
}

// 修改常见急救方法
export function updateAid(data) {
  return request({
    url: '/health/aid',
    method: 'put',
    data: data
  })
}

// 删除常见急救方法
export function delAid(id) {
  return request({
    url: '/health/aid/' + id,
    method: 'delete'
  })
}
