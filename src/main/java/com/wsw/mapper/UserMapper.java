package com.wsw.mapper;

import com.wsw.entity.db.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User selectByUid(int uid);

    User selectByUname(@Param("user") String user);

    User selectByTel(User user);

    User login(User user);

    void register(User user);

    void update(User user);
}