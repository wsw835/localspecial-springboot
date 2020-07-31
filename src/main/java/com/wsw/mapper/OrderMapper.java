package com.wsw.mapper;

import com.wsw.entity.db.Order;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface OrderMapper {

    void insert(Order order);

    Order selectLast();

    List<Order> selectAllOrder(int uid);

    void delete(int oId);

    Order selectByOrid(int oid);

    void update();
}