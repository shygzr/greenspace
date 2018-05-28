package com.greenspace.service.impl;

import com.greenspace.dao.UserMapper;
import com.greenspace.model.User;
import com.greenspace.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor=Exception.class,readOnly=true)
    @Override
    public Optional<User> selectByUserName(String userName) {
        return Optional.ofNullable(userMapper.selectByUserName(userName));
    }

    @Transactional(rollbackFor=Exception.class,readOnly=true)
    @Override
    public boolean existUserName(String userName) {
        Optional<User> oUser = selectByUserName(userName);
        if (oUser.isPresent()){
            return true;
        } else {
            return false;
        }
    }

    @Transactional(rollbackFor=Exception.class,readOnly=false)
    @Override
    public boolean insertUser(User user) {
        if(!existUserName(user.getUserName())){
            userMapper.insert(user);
            return true;
        } else {
            return false;
        }
    }

    @Transactional(rollbackFor=Exception.class,readOnly=false)
    @Override
    public boolean changePassword(String userName, String oldPassword, String newPadssword) {
        User user = userMapper.selectByUserName(userName);
        if(oldPassword.equals(user.getPassword())){
            user.setPassword(newPadssword);
            userMapper.updateByPrimaryKeySelective(user);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Long checkPassword(String userName, String password) {
        User user = userMapper.selectByUserName(userName);
        if(ObjectUtils.isEmpty(user)) {
            return null;
        } else {
            if(password.equals(user.getPassword())){
                return user.getId();
            }
        }
        return null;

    }
}
