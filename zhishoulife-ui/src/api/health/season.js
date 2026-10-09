import request from '@/utils/request'

// 查询四季养生常识列表
export function listSeason(query) {
  return request({
    url: '/health/season/list',
    method: 'get',
    params: query
  })
}

// 查询四季养生常识详细
export function getSeason(id) {
  return request({
    url: '/health/season/' + id,
    method: 'get'
  })
}

// 新增四季养生常识
export function addSeason(data) {
  return request({
    url: '/health/season',
    method: 'post',
    data: data
  })
}

// 修改四季养生常识
export function updateSeason(data) {
  return request({
    url: '/health/season',
    method: 'put',
    data: data
  })
}

// 删除四季养生常识
export function delSeason(id) {
  return request({
    url: '/health/season/' + id,
    method: 'delete'
  })
}
