package com.wsw.mapper;

import com.wsw.entity.db.Shoppingcart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ShoppingcartMapper {

    List<Shoppingcart> selectAll(int uid);

    void insert(Shoppingcart shoppingcart);

    void delete(int sId);

    int selectCountByUid(int uId);

    Shoppingcart selectBySid(int sId);
}