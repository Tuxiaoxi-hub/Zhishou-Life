import request from '@/utils/request'

// 查询药物安全列表
export function listDrug(query) {
  return request({
    url: '/health/drug/list',
    method: 'get',
    params: query
  })
}

// 查询药物安全详细
export function getDrug(id) {
  return request({
    url: '/health/drug/' + id,
    method: 'get'
  })
}

// 新增药物安全
export function addDrug(data) {
  return request({
    url: '/health/drug',
    method: 'post',
    data: data
  })
}

// 修改药物安全
export function updateDrug(data) {
  return request({
    url: '/health/drug',
    method: 'put',
    data: data
  })
}

// 删除药物安全
export function delDrug(id) {
  return request({
    url: '/health/drug/' + id,
    method: 'delete'
  })
}
