import request from '@/utils/request'

// 查询交通通行规则列表
export function listCommon(query) {
  return request({
    url: '/taffic/common/list',
    method: 'get',
    params: query
  })
}

// 查询交通通行规则详细
export function getCommon(id) {
  return request({
    url: '/taffic/common/' + id,
    method: 'get'
  })
}

// 新增交通通行规则
export function addCommon(data) {
  return request({
    url: '/taffic/common',
    method: 'post',
    data: data
  })
}

// 修改交通通行规则
export function updateCommon(data) {
  return request({
    url: '/taffic/common',
    method: 'put',
    data: data
  })
}

// 删除交通通行规则
export function delCommon(id) {
  return request({
    url: '/taffic/common/' + id,
    method: 'delete'
  })
}
