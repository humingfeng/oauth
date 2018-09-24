package com.humingfeng.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.humingfeng.mapper.SysPermissionMapper;
import com.humingfeng.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
*@ClassName     PermissionServiceImpl
*@description   TODO
*@author        胡铭锋
*@Date          2018/9/24 21:48
*@Version       1.0
**/
@Service
public class PermissionServiceImpl implements PermissionService {
    private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 查询某用户的 角色  菜单列表   权限列表
     *
     * @param username
     * @return
     */
    @Override
    public JSONObject getUserPermission(String username) {
        JSONObject userPermission = getUserPermissionFromDB(username);
        return userPermission;
    }

    /**
     * 从数据库查询用户权限信息
     *
     * @param username
     * @return
     */
    private JSONObject getUserPermissionFromDB(String username) {
        JSONObject userPermission = sysPermissionMapper.getUserPermission(username);
        //管理员角色ID为1
        int adminRoleId = 1;
        //如果是管理员
        String roleIdKey = "roleId";
        if (adminRoleId == userPermission.getIntValue(roleIdKey)) {
            //查询所有菜单  所有权限
            Set<String> menuList = sysPermissionMapper.getAllMenu();
            Set<String> permissionList = sysPermissionMapper.getAllPermission();
            userPermission.put("menuList", menuList);
            userPermission.put("permissionList", permissionList);
        }
        return userPermission;
    }
}
