import request from '@/utils/request'

// 查询交通标志识别列表
export function listSign(query) {
  return request({
    url: '/traffic/sign/list',
    method: 'get',
    params: query
  })
}

// 查询交通标志识别详细
export function getSign(id) {
  return request({
    url: '/traffic/sign/' + id,
    method: 'get'
  })
}

// 新增交通标志识别
export function addSign(data) {
  return request({
    url: '/traffic/sign',
    method: 'post',
    data: data
  })
}

// 修改交通标志识别
export function updateSign(data) {
  return request({
    url: '/traffic/sign',
    method: 'put',
    data: data
  })
}

// 删除交通标志识别
export function delSign(id) {
  return request({
    url: '/traffic/sign/' + id,
    method: 'delete'
  })
}
