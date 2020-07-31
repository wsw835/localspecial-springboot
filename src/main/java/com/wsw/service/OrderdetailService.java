package com.wsw.service;

import com.wsw.entity.db.Orderdetail;
import com.wsw.mapper.OrderdetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderdetailService {
    @Autowired
    private OrderdetailMapper orderdetailMapper;

    public void insert(Orderdetail order) {
        orderdetailMapper.insert(order);
    }

    public List<Orderdetail> selectAll(int orId) {
        List<Orderdetail> list = orderdetailMapper.selectAll(orId);
        return list;
    }

    public void delete(int id) {
        orderdetailMapper.delete(id);
    }
}
