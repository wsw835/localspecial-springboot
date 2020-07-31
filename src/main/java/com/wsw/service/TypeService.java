package com.wsw.service;

import com.wsw.entity.db.Type;
import com.wsw.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public List<Type> selectAllType() {
        List<Type> list = typeMapper.selectAllType();
        return list;
    }

    public Type selectByTid(int tid) {
        Type type = typeMapper.selectById(tid);
        return type;
    }

}
