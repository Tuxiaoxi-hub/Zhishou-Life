import request from '@/utils/request'

// 查询常见消费纠纷处理列表
export function listDispute(query) {
  return request({
    url: '/life/dispute/list',
    method: 'get',
    params: query
  })
}

// 查询常见消费纠纷处理详细
export function getDispute(id) {
  return request({
    url: '/life/dispute/' + id,
    method: 'get'
  })
}

// 新增常见消费纠纷处理
export function addDispute(data) {
  return request({
    url: '/life/dispute',
    method: 'post',
    data: data
  })
}

// 修改常见消费纠纷处理
export function updateDispute(data) {
  return request({
    url: '/life/dispute',
    method: 'put',
    data: data
  })
}

// 删除常见消费纠纷处理
export function delDispute(id) {
  return request({
    url: '/life/dispute/' + id,
    method: 'delete'
  })
}
