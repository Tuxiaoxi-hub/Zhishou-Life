import request from '@/utils/request'

// 查询办公软件技能列表
export function listOffice(query) {
  return request({
    url: '/study/office/list',
    method: 'get',
    params: query
  })
}

// 查询办公软件技能详细
export function getOffice(id) {
  return request({
    url: '/study/office/' + id,
    method: 'get'
  })
}

// 新增办公软件技能
export function addOffice(data) {
  return request({
    url: '/study/office',
    method: 'post',
    data: data
  })
}

// 修改办公软件技能
export function updateOffice(data) {
  return request({
    url: '/study/office',
    method: 'put',
    data: data
  })
}

// 删除办公软件技能
export function delOffice(id) {
  return request({
    url: '/study/office/' + id,
    method: 'delete'
  })
}
