package com.wsw.mapper;

import com.wsw.entity.db.Orderdetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface OrderdetailMapper {

    void insert(Orderdetail order);

    List<Orderdetail> selectAll(int orId);

    void delete(int odId);

    List<Orderdetail> selectDetail();

}