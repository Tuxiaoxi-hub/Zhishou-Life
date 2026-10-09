import request from '@/utils/request'

// 查询消费维权渠道列表
export function listChannel(query) {
  return request({
    url: '/life/channel/list',
    method: 'get',
    params: query
  })
}

// 查询消费维权渠道详细
export function getChannel(id) {
  return request({
    url: '/life/channel/' + id,
    method: 'get'
  })
}

// 新增消费维权渠道
export function addChannel(data) {
  return request({
    url: '/life/channel',
    method: 'post',
    data: data
  })
}

// 修改消费维权渠道
export function updateChannel(data) {
  return request({
    url: '/life/channel',
    method: 'put',
    data: data
  })
}

// 删除消费维权渠道
export function delChannel(id) {
  return request({
    url: '/life/channel/' + id,
    method: 'delete'
  })
}
