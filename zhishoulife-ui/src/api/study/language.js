import request from '@/utils/request'

// 查询语言类证书列表
export function listLanguage(query) {
  return request({
    url: '/study/language/list',
    method: 'get',
    params: query
  })
}

// 查询语言类证书详细
export function getLanguage(id) {
  return request({
    url: '/study/language/' + id,
    method: 'get'
  })
}

// 新增语言类证书
export function addLanguage(data) {
  return request({
    url: '/study/language',
    method: 'post',
    data: data
  })
}

// 修改语言类证书
export function updateLanguage(data) {
  return request({
    url: '/study/language',
    method: 'put',
    data: data
  })
}

// 删除语言类证书
export function delLanguage(id) {
  return request({
    url: '/study/language/' + id,
    method: 'delete'
  })
}
