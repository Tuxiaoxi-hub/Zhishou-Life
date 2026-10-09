import request from '@/utils/request'

// 查询污渍去除技巧列表
export function listStain(query) {
  return request({
    url: '/life/stain/list',
    method: 'get',
    params: query
  })
}

// 查询污渍去除技巧详细
export function getStain(id) {
  return request({
    url: '/life/stain/' + id,
    method: 'get'
  })
}

// 新增污渍去除技巧
export function addStain(data) {
  return request({
    url: '/life/stain',
    method: 'post',
    data: data
  })
}

// 修改污渍去除技巧
export function updateStain(data) {
  return request({
    url: '/life/stain',
    method: 'put',
    data: data
  })
}

// 删除污渍去除技巧
export function delStain(id) {
  return request({
    url: '/life/stain/' + id,
    method: 'delete'
  })
}
