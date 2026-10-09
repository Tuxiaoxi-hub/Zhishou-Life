import request from '@/utils/request'

// 查询体检知识科普列表
export function listCheckup(query) {
  return request({
    url: '/health/checkup/list',
    method: 'get',
    params: query
  })
}

// 查询体检知识科普详细
export function getCheckup(id) {
  return request({
    url: '/health/checkup/' + id,
    method: 'get'
  })
}

// 新增体检知识科普
export function addCheckup(data) {
  return request({
    url: '/health/checkup',
    method: 'post',
    data: data
  })
}

// 修改体检知识科普
export function updateCheckup(data) {
  return request({
    url: '/health/checkup',
    method: 'put',
    data: data
  })
}

// 删除体检知识科普
export function delCheckup(id) {
  return request({
    url: '/health/checkup/' + id,
    method: 'delete'
  })
}
