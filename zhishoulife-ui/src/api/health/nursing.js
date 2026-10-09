import request from '@/utils/request'

// 查询常见病症护理列表
export function listNursing(query) {
  return request({
    url: '/health/nursing/list',
    method: 'get',
    params: query
  })
}

// 查询常见病症护理详细
export function getNursing(id) {
  return request({
    url: '/health/nursing/' + id,
    method: 'get'
  })
}

// 新增常见病症护理
export function addNursing(data) {
  return request({
    url: '/health/nursing',
    method: 'post',
    data: data
  })
}

// 修改常见病症护理
export function updateNursing(data) {
  return request({
    url: '/health/nursing',
    method: 'put',
    data: data
  })
}

// 删除常见病症护理
export function delNursing(id) {
  return request({
    url: '/health/nursing/' + id,
    method: 'delete'
  })
}
