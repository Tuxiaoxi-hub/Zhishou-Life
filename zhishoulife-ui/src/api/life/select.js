import request from '@/utils/request'

// 查询食材挑选与保存列表
export function listSelect(query) {
  return request({
    url: '/life/select/list',
    method: 'get',
    params: query
  })
}

// 查询食材挑选与保存详细
export function getSelect(id) {
  return request({
    url: '/life/select/' + id,
    method: 'get'
  })
}

// 新增食材挑选与保存
export function addSelect(data) {
  return request({
    url: '/life/select',
    method: 'post',
    data: data
  })
}

// 修改食材挑选与保存
export function updateSelect(data) {
  return request({
    url: '/life/select',
    method: 'put',
    data: data
  })
}

// 删除食材挑选与保存
export function delSelect(id) {
  return request({
    url: '/life/select/' + id,
    method: 'delete'
  })
}
