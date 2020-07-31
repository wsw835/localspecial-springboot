package com.wsw.service;

import com.wsw.entity.db.User;
import com.wsw.mapper.UserMapper;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void reg(User user) {
        if (user != null && StringUtils.isNotBlank(user.getuPassword())) {
            //如果密码不为空，则使用md5加密工具类加密密码
            user.setuPassword(DigestUtils.md5Hex(user.getuPassword()));
        }
        userMapper.register(user);
    }

    public User login(User user) {
        user = userMapper.login(user);
        return user;
    }

    public User selectByUname(String user) {
        return  userMapper.selectByUname(user);
    }

    public User selectByTel(User user) {
        user = userMapper.selectByTel(user);
        return user;
    }

    public User selectByUid(int uid) {
        User user = userMapper.selectByUid(uid);
        return user;
    }

    public void update(User user) {
        userMapper.update(user);
    }
}
