package com.greenspace.service.impl;

import com.greenspace.dao.*;
import com.greenspace.model.*;
import com.greenspace.service.IAuthUserService;
import com.greenspace.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class AuthUserServiceImpl implements IAuthUserService {

    @Autowired
    private AuthUserRoleMapper authUserRoleMapper;
    @Autowired
    private AuthRoleMapper authRoleMapper;
    @Autowired
    private AuthRolePermissionMapper authRolePermissionMapper;
    @Autowired
    private AuthPermissionMapper authPermissionMapper;
    @Autowired
    private AuthUserMapper authUserMapper;

    @Transactional(rollbackFor=Exception.class,readOnly=true)
    @Override
    public Optional<AuthUser> getUserByUserName(String userName) {
        return Optional.ofNullable(authUserMapper.selectByUserName(userName));
    }

    @Transactional(rollbackFor=Exception.class,readOnly=true)
    @Override
    public List<AuthRole> getUserRoleListByUserId(Long userId) {
        List<Long> roleIds = authUserRoleMapper.selectRoleIdListByUserId(userId);
        List<AuthRole> res = new ArrayList<AuthRole>();
        for (Long roleId : roleIds) {
            res.add(authRoleMapper.selectByPrimaryKey(roleId));
        }
        return res;
    }

    @Transactional(rollbackFor=Exception.class,readOnly=true)
    @Override
    public List<AuthPermission> getUserPermissionByUserId(Long userId) {
        List<Long> roleIds = authUserRoleMapper.selectRoleIdListByUserId(userId);
        Set<Long> permissionIdres = new HashSet<Long>();
        List<AuthPermission> res = new ArrayList<AuthPermission>();
        for (Long roleId : roleIds) {
            List<Long> permissionIds = authRolePermissionMapper.selectPermissionIdListByRoleId(roleId);
            for(Long permissionId : permissionIds) {
                permissionIdres.add(permissionId);
            }
        }
        for(Long permissionId : permissionIdres) {
            res.add(authPermissionMapper.selectByPrimaryKey(permissionId));
        }
        return res;
    }
}
