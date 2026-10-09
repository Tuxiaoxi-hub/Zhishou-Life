import request from '@/utils/request'

// 查询家电操作技巧列表
export function listUse(query) {
  return request({
    url: '/home/use/list',
    method: 'get',
    params: query
  })
}

// 查询家电操作技巧详细
export function getUse(id) {
  return request({
    url: '/home/use/' + id,
    method: 'get'
  })
}

// 新增家电操作技巧
export function addUse(data) {
  return request({
    url: '/home/use',
    method: 'post',
    data: data
  })
}

// 修改家电操作技巧
export function updateUse(data) {
  return request({
    url: '/home/use',
    method: 'put',
    data: data
  })
}

// 删除家电操作技巧
export function delUse(id) {
  return request({
    url: '/home/use/' + id,
    method: 'delete'
  })
}
