package com.greenspace.dao;

import com.greenspace.model.AuthPermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthPermission record);

    int insertSelective(AuthPermission record);

    AuthPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthPermission record);

    int updateByPrimaryKey(AuthPermission record);
}