package com.wsw.mapper;

import com.wsw.entity.db.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CommentsMapper {

    List<Comments> selectAllByGid(int gid);

    void insert(Comments comments);
}
