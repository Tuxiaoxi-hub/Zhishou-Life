import request from '@/utils/request'

// 查询运动健身常识列表
export function listSport(query) {
  return request({
    url: '/health/sport/list',
    method: 'get',
    params: query
  })
}

// 查询运动健身常识详细
export function getSport(id) {
  return request({
    url: '/health/sport/' + id,
    method: 'get'
  })
}

// 新增运动健身常识
export function addSport(data) {
  return request({
    url: '/health/sport',
    method: 'post',
    data: data
  })
}

// 修改运动健身常识
export function updateSport(data) {
  return request({
    url: '/health/sport',
    method: 'put',
    data: data
  })
}

// 删除运动健身常识
export function delSport(id) {
  return request({
    url: '/health/sport/' + id,
    method: 'delete'
  })
}
