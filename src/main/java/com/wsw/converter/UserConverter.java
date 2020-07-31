package com.wsw.converter;

import com.wsw.entity.db.User;
import com.wsw.entity.vo.UserRegVO;

public class UserConverter {
    public static User userConverter(UserRegVO userRegVO) {
        User user = new User();
        user.setuName(userRegVO.getUName());
        user.setuRealname(userRegVO.getURealName());
        user.setuTelephone(userRegVO.getUTel());
        user.setuPassword(userRegVO.getPassword());
        return user;
    }
}
