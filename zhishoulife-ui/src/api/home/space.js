import request from '@/utils/request'

// 查询空间收纳技巧列表
export function listSpace(query) {
  return request({
    url: '/home/space/list',
    method: 'get',
    params: query
  })
}

// 查询空间收纳技巧详细
export function getSpace(id) {
  return request({
    url: '/home/space/' + id,
    method: 'get'
  })
}

// 新增空间收纳技巧
export function addSpace(data) {
  return request({
    url: '/home/space',
    method: 'post',
    data: data
  })
}

// 修改空间收纳技巧
export function updateSpace(data) {
  return request({
    url: '/home/space',
    method: 'put',
    data: data
  })
}

// 删除空间收纳技巧
export function delSpace(id) {
  return request({
    url: '/home/space/' + id,
    method: 'delete'
  })
}
