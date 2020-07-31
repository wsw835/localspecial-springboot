package com.wsw.service;

import com.wsw.entity.db.Shoppingcart;
import com.wsw.mapper.ShoppingcartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingcartService {
    @Autowired
    private ShoppingcartMapper shoppingcartMapper;

    public void insert(Shoppingcart shoppingcart) {
        shoppingcartMapper.insert(shoppingcart);
    }

    public List<Shoppingcart> selectAll(int uid) {
        List<Shoppingcart> list = shoppingcartMapper.selectAll(uid);
        return list;
    }

    public void delete(int sid) {
        shoppingcartMapper.delete(sid);
    }

    public int selectCountByUid(int uid) {
        int count = shoppingcartMapper.selectCountByUid(uid);
        return count;
    }

    public Shoppingcart selectBySid(int sid){
        Shoppingcart shoppingcart=shoppingcartMapper.selectBySid(sid);
        return  shoppingcart;
    }
}
