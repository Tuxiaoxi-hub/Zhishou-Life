import request from '@/utils/request'

// 查询职业资格证书列表
export function listProfession(query) {
  return request({
    url: '/study/profession/list',
    method: 'get',
    params: query
  })
}

// 查询职业资格证书详细
export function getProfession(id) {
  return request({
    url: '/study/profession/' + id,
    method: 'get'
  })
}

// 新增职业资格证书
export function addProfession(data) {
  return request({
    url: '/study/profession',
    method: 'post',
    data: data
  })
}

// 修改职业资格证书
export function updateProfession(data) {
  return request({
    url: '/study/profession',
    method: 'put',
    data: data
  })
}

// 删除职业资格证书
export function delProfession(id) {
  return request({
    url: '/study/profession/' + id,
    method: 'delete'
  })
}
