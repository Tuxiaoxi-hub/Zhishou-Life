import request from '@/utils/request'

// 查询网络诈骗防范列表
export function listFraud(query) {
  return request({
    url: '/safety/fraud/list',
    method: 'get',
    params: query
  })
}

// 查询网络诈骗防范详细
export function getFraud(id) {
  return request({
    url: '/safety/fraud/' + id,
    method: 'get'
  })
}

// 新增网络诈骗防范
export function addFraud(data) {
  return request({
    url: '/safety/fraud',
    method: 'post',
    data: data
  })
}

// 修改网络诈骗防范
export function updateFraud(data) {
  return request({
    url: '/safety/fraud',
    method: 'put',
    data: data
  })
}

// 删除网络诈骗防范
export function delFraud(id) {
  return request({
    url: '/safety/fraud/' + id,
    method: 'delete'
  })
}
