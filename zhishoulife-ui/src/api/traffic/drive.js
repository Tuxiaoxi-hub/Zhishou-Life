import request from '@/utils/request'

// 查询自驾出行安全列表
export function listDrive(query) {
  return request({
    url: '/traffic/drive/list',
    method: 'get',
    params: query
  })
}

// 查询自驾出行安全详细
export function getDrive(id) {
  return request({
    url: '/traffic/drive/' + id,
    method: 'get'
  })
}

// 新增自驾出行安全
export function addDrive(data) {
  return request({
    url: '/traffic/drive',
    method: 'post',
    data: data
  })
}

// 修改自驾出行安全
export function updateDrive(data) {
  return request({
    url: '/traffic/drive',
    method: 'put',
    data: data
  })
}

// 删除自驾出行安全
export function delDrive(id) {
  return request({
    url: '/traffic/drive/' + id,
    method: 'delete'
  })
}
