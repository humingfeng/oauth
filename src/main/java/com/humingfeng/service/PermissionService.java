package com.humingfeng.service;

import com.alibaba.fastjson.JSONObject;

/**
*@ClassName     PermissionService
*@description   TODO
*@author        胡铭锋
*@Date          2018/9/24 21:48
*@Version       1.0
**/
public interface PermissionService {
    /**
     * 查询某用户的 角色  菜单列表   权限列表
     *
     * @param username
     * @return
     */
    JSONObject getUserPermission(String username);
}
