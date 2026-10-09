import request from '@/utils/request'

// 查询生活实用技能列表
export function listLifee(query) {
  return request({
    url: '/study/lifee/list',
    method: 'get',
    params: query
  })
}

// 查询生活实用技能详细
export function getLifee(id) {
  return request({
    url: '/study/lifee/' + id,
    method: 'get'
  })
}

// 新增生活实用技能
export function addLifee(data) {
  return request({
    url: '/study/lifee',
    method: 'post',
    data: data
  })
}

// 修改生活实用技能
export function updateLifee(data) {
  return request({
    url: '/study/lifee',
    method: 'put',
    data: data
  })
}

// 删除生活实用技能
export function delLifee(id) {
  return request({
    url: '/study/lifee/' + id,
    method: 'delete'
  })
}
