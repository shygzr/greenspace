package com.greenspace.service;

import com.greenspace.model.AuthPermission;
import com.greenspace.model.AuthRole;
import com.greenspace.model.AuthUser;
import com.greenspace.model.User;

import java.util.List;
import java.util.Optional;

public interface IAuthUserService {

    //获取用户
    public Optional<AuthUser> getUserByUserName(String userName);

    //获得用户角色
    public List<AuthRole> getUserRoleListByUserId(Long userId);

    //获得用户权限
    public List<AuthPermission> getUserPermissionByUserId(Long userId);
}
