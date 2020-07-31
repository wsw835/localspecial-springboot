package com.wsw.service;

import com.wsw.entity.db.Goods;
import com.wsw.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    public List<Goods> selectTen() {
        List<Goods> list = goodsMapper.selectTen();
        Object o1=new Object();
        return list;
    }

    public List<Goods> selectNew() {
        List<Goods> list = goodsMapper.selectNew();
        return list;
    }

    public void insert(Goods goods) {
        goodsMapper.insert(goods);
    }

    public List<Goods> selectAll() {
        List<Goods> list = goodsMapper.selectAll();
        return list;
    }

    public Goods selectByGid(int id) {
        Goods goods = goodsMapper.selectByGid(id);
        return goods;
    }

    public List<Goods> selectByTid(int tid) {
        List<Goods> list = goodsMapper.selectByTid(tid);
        return list;
    }

    public void updateStock(int gid){
        goodsMapper.updateStock(gid);
    }
}
