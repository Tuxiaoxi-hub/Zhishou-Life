import request from '@/utils/request'

// 查询外伤应急处理列表
export function listTrauma(query) {
  return request({
    url: '/health/trauma/list',
    method: 'get',
    params: query
  })
}

// 查询外伤应急处理详细
export function getTrauma(id) {
  return request({
    url: '/health/trauma/' + id,
    method: 'get'
  })
}

// 新增外伤应急处理
export function addTrauma(data) {
  return request({
    url: '/health/trauma',
    method: 'post',
    data: data
  })
}

// 修改外伤应急处理
export function updateTrauma(data) {
  return request({
    url: '/health/trauma',
    method: 'put',
    data: data
  })
}

// 删除外伤应急处理
export function delTrauma(id) {
  return request({
    url: '/health/trauma/' + id,
    method: 'delete'
  })
}
