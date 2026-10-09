import request from '@/utils/request'

// 查询衣物清洗保养列表
export function listClean(query) {
  return request({
    url: '/life/clean/list',
    method: 'get',
    params: query
  })
}

// 查询衣物清洗保养详细
export function getClean(id) {
  return request({
    url: '/life/clean/' + id,
    method: 'get'
  })
}

// 新增衣物清洗保养
export function addClean(data) {
  return request({
    url: '/life/clean',
    method: 'post',
    data: data
  })
}

// 修改衣物清洗保养
export function updateClean(data) {
  return request({
    url: '/life/clean',
    method: 'put',
    data: data
  })
}

// 删除衣物清洗保养
export function delClean(id) {
  return request({
    url: '/life/clean/' + id,
    method: 'delete'
  })
}
