import request from '@/utils/request'

// 查询家电保养维护列表
export function listMaintain(query) {
  return request({
    url: '/home/maintain/list',
    method: 'get',
    params: query
  })
}

// 查询家电保养维护详细
export function getMaintain(id) {
  return request({
    url: '/home/maintain/' + id,
    method: 'get'
  })
}

// 新增家电保养维护
export function addMaintain(data) {
  return request({
    url: '/home/maintain',
    method: 'post',
    data: data
  })
}

// 修改家电保养维护
export function updateMaintain(data) {
  return request({
    url: '/home/maintain',
    method: 'put',
    data: data
  })
}

// 删除家电保养维护
export function delMaintain(id) {
  return request({
    url: '/home/maintain/' + id,
    method: 'delete'
  })
}
