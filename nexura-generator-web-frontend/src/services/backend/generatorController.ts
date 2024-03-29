// @ts-ignore
/* eslint-disable */
import { request } from '@umijs/max';

/** addGenerator POST /api/generator/add */
export async function addGeneratorUsingPOST(
  body: API.GeneratorAddRequest,
  options?: { [key: string]: any },
) {
  return request<API.BaseResponselong>('/generator/add', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** deleteGenerator POST /api/generator/delete */
export async function deleteGeneratorUsingPOST(
  body: API.DeleteRequest,
  options?: { [key: string]: any },
) {
  return request<API.BaseResponseboolean>('/generator/delete', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** editGenerator POST /api/generator/edit */
export async function editGeneratorUsingPOST(
  body: API.GeneratorEditRequest,
  options?: { [key: string]: any },
) {
  return request<API.BaseResponseboolean>('/generator/edit', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** getGeneratorVOById GET /api/generator/get/vo */
export async function getGeneratorVOByIdUsingGET(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.getGeneratorVOByIdUsingGETParams,
  options?: { [key: string]: any },
) {
  return request<API.BaseResponseGeneratorVO>('/generator/get/vo', {
    method: 'GET',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

/** listGeneratorByPage POST /api/generator/list/page */
export async function listGeneratorByPageUsingPOST(
  body: API.GeneratorQueryRequest,
  options?: { [key: string]: any },
) {
  return request<API.BaseResponsePageGenerator>('/generator/list/page', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** listGeneratorVOByPage POST /api/generator/list/page/vo */
export async function listGeneratorVOByPageUsingPOST(
  body: API.GeneratorQueryRequest,
  options?: { [key: string]: any },
) {
  return request<API.BaseResponsePageGeneratorVO>('/generator/list/page/vo', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** listMyGeneratorVOByPage POST /api/generator/my/list/page/vo */
export async function listMyGeneratorVOByPageUsingPOST(
  body: API.GeneratorQueryRequest,
  options?: { [key: string]: any },
) {
  return request<API.BaseResponsePageGeneratorVO>('/generator/my/list/page/vo', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** updateGenerator POST /api/generator/update */
export async function updateGeneratorUsingPOST(
  body: API.GeneratorUpdateRequest,
  options?: { [key: string]: any },
) {
  return request<API.BaseResponseboolean>('/generator/update', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}
