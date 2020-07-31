package com.wsw.mapper;

import com.wsw.entity.db.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface GoodsMapper {

    void insert(Goods good);

    List<Goods> selectTen();

    List<Goods> selectNew();

    List<Goods> selectAll();

    Goods selectByGid(int id);

    List<Goods> selectByTid(int tid);

    void updateStock(int gid);

    String getIdOfProvince(@Param("pos")String pos);

    List<Goods> listGoodsOfLocate(@Param("id")String id);
}