package com.wsw.mapper;

import com.wsw.entity.db.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TypeMapper {

    List<Type> selectAllType();

    Type selectById(int tid);

}