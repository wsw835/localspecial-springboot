package com.wsw.service;

import com.wsw.entity.db.Order;
import com.wsw.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public void insert(Order order) {
        orderMapper.insert(order);
    }

    public Order selectLast() {
        Order order = orderMapper.selectLast();
        return order;
    }

    public List<Order> selectAllOrder(int uid) {
        List<Order> list = orderMapper.selectAllOrder(uid);
        return list;
    }

    public void delete(int orId) {
        orderMapper.delete(orId);
    }

    public Order selectByOid(int oid) {
        Order order = orderMapper.selectByOrid(oid);
        return order;
    }

    public void update() {
        orderMapper.update();
    }
}
