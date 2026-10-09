import request from '@/utils/request'

// 查询衣物收纳整理列表
export function listStorageee(query) {
  return request({
    url: '/life/storageee/list',
    method: 'get',
    params: query
  })
}

// 查询衣物收纳整理详细
export function getStorageee(id) {
  return request({
    url: '/life/storageee/' + id,
    method: 'get'
  })
}

// 新增衣物收纳整理
export function addStorageee(data) {
  return request({
    url: '/life/storageee',
    method: 'post',
    data: data
  })
}

// 修改衣物收纳整理
export function updateStorageee(data) {
  return request({
    url: '/life/storageee',
    method: 'put',
    data: data
  })
}

// 删除衣物收纳整理
export function delStorageee(id) {
  return request({
    url: '/life/storageee/' + id,
    method: 'delete'
  })
}
