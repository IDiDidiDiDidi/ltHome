import request from '@/utils/request'

// 查询吃什么列表
export function listEat(query) {
  return request({
    url: '/system/eat/list',
    method: 'get',
    params: query
  })
}

// 查询吃什么详细
export function getEat(id) {
  return request({
    url: '/system/eat/' + id,
    method: 'get'
  })
}

// 新增吃什么
export function addEat(data) {
  return request({
    url: '/system/eat',
    method: 'post',
    data: data
  })
}

// 修改吃什么
export function updateEat(data) {
  return request({
    url: '/system/eat',
    method: 'put',
    data: data
  })
}

// 删除吃什么
export function delEat(id) {
  return request({
    url: '/system/eat/' + id,
    method: 'delete'
  })
}

// dictData
export function dictData(dictType) {
  return request({
    url: 'system/dict/data/list?pageNum=1&pageSize=1000&dictType=' + dictType,
    method: 'get'
  })
}