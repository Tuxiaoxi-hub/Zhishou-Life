import request from '@/utils/request'

// 查询就医流程指南列表
export function listProcess(query) {
  return request({
    url: '/health/process/list',
    method: 'get',
    params: query
  })
}

// 查询就医流程指南详细
export function getProcess(id) {
  return request({
    url: '/health/process/' + id,
    method: 'get'
  })
}

// 新增就医流程指南
export function addProcess(data) {
  return request({
    url: '/health/process',
    method: 'post',
    data: data
  })
}

// 修改就医流程指南
export function updateProcess(data) {
  return request({
    url: '/health/process',
    method: 'put',
    data: data
  })
}

// 删除就医流程指南
export function delProcess(id) {
  return request({
    url: '/health/process/' + id,
    method: 'delete'
  })
}
