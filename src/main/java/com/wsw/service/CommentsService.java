package com.wsw.service;

import com.wsw.entity.db.Comments;
import com.wsw.mapper.CommentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;

    public List<Comments> selectAll(int gid) {
        List<Comments> list = commentsMapper.selectAllByGid(gid);
        return list;
    }

    public void insert(Comments comments) {
        commentsMapper.insert(comments);
    }
}
