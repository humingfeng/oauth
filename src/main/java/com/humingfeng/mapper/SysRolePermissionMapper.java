package com.humingfeng.mapper;

import com.humingfeng.pojo.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}