package com.wsw.converter;

import com.wsw.entity.db.Goods;
import com.wsw.entity.db.Type;
import com.wsw.entity.vo.GoodsVO;


public class GoodsConverter {

    public static Goods goodsConverter(GoodsVO goodsVO, String img) {
        Goods goods = new Goods();
        Type type = new Type();
        type.settId(goodsVO.getTypeId());
        goods.setgName(goodsVO.getName());
        goods.setgPrice(goodsVO.getPrice());
        goods.setgStock(goodsVO.getStore());
        goods.setgImage(img);
        goods.setgDate(goodsVO.getDate());
        goods.setgAbout(goodsVO.getAbout());
        goods.setType(type);
        return goods;
    }
}
