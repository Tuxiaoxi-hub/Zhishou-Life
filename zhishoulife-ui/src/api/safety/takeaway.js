import request from '@/utils/request'

// 查询外卖安全常识列表
export function listTakeaway(query) {
  return request({
    url: '/safety/takeaway/list',
    method: 'get',
    params: query
  })
}

// 查询外卖安全常识详细
export function getTakeaway(id) {
  return request({
    url: '/safety/takeaway/' + id,
    method: 'get'
  })
}

// 新增外卖安全常识
export function addTakeaway(data) {
  return request({
    url: '/safety/takeaway',
    method: 'post',
    data: data
  })
}

// 修改外卖安全常识
export function updateTakeaway(data) {
  return request({
    url: '/safety/takeaway',
    method: 'put',
    data: data
  })
}

// 删除外卖安全常识
export function delTakeaway(id) {
  return request({
    url: '/safety/takeaway/' + id,
    method: 'delete'
  })
}
