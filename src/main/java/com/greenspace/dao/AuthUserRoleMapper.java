package com.greenspace.dao;

import com.greenspace.model.AuthUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthUserRole record);

    int insertSelective(AuthUserRole record);

    AuthUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthUserRole record);

    int updateByPrimaryKey(AuthUserRole record);

    //用户角色Id列表
    List<Long> selectRoleIdListByUserId(Long id);
}