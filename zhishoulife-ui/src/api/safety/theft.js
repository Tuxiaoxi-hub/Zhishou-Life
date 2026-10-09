import request from '@/utils/request'

// 查询防盗防入侵列表
export function listTheft(query) {
  return request({
    url: '/safety/theft/list',
    method: 'get',
    params: query
  })
}

// 查询防盗防入侵详细
export function getTheft(id) {
  return request({
    url: '/safety/theft/' + id,
    method: 'get'
  })
}

// 新增防盗防入侵
export function addTheft(data) {
  return request({
    url: '/safety/theft',
    method: 'post',
    data: data
  })
}

// 修改防盗防入侵
export function updateTheft(data) {
  return request({
    url: '/safety/theft',
    method: 'put',
    data: data
  })
}

// 删除防盗防入侵
export function delTheft(id) {
  return request({
    url: '/safety/theft/' + id,
    method: 'delete'
  })
}
