package com.greenspace.service;

import com.greenspace.model.User;

import java.util.Optional;

public interface IUserService {

    public Optional<User> selectByUserName(String userName);

    //检查用户名是否存在
    public boolean existUserName(String userName);

    //新建用户
    public boolean insertUser(User user);

    //修改密码
    public boolean changePassword(String userName, String oldPassword, String newPadssword);

    //核对密码,返回id
    public Long checkPassword(String userName, String password);
}
