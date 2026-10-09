import request from '@/utils/request'

// 错误示例（路径不对）：/system/user/front/register
// 正确示例（必须和SecurityConfig中放行的/register一致）：
export function register(data) {
  return request({
    url: '/register', // 重点：必须是/register，不能加任何前缀
    method: 'post',   // 重点：必须是POST方法
    data: data
  })
}