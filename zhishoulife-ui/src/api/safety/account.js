import request from '@/utils/request'

// 查询账号安全防护列表
export function listAccount(query) {
  return request({
    url: '/safety/account/list',
    method: 'get',
    params: query
  })
}

// 查询账号安全防护详细
export function getAccount(id) {
  return request({
    url: '/safety/account/' + id,
    method: 'get'
  })
}

// 新增账号安全防护
export function addAccount(data) {
  return request({
    url: '/safety/account',
    method: 'post',
    data: data
  })
}

// 修改账号安全防护
export function updateAccount(data) {
  return request({
    url: '/safety/account',
    method: 'put',
    data: data
  })
}

// 删除账号安全防护
export function delAccount(id) {
  return request({
    url: '/safety/account/' + id,
    method: 'delete'
  })
}
