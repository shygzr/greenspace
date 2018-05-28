package com.greenspace.dao;

import com.greenspace.model.AuthRolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthRolePermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthRolePermission record);

    int insertSelective(AuthRolePermission record);

    AuthRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthRolePermission record);

    int updateByPrimaryKey(AuthRolePermission record);

    //用户权限Id列表
    List<Long> selectPermissionIdListByRoleId(Long id);
}