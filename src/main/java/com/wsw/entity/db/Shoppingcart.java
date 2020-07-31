/*
 * @(#) Shoppingcart
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2019
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author 温思伟
 * <br> 2019-11-23 10:45:13
 */

package com.wsw.entity.db;

import lombok.ToString;

@ToString
public class Shoppingcart {
   public Integer sId;

   public Integer sCount;

   public Double sTotal;

   public Integer gId;

   public Integer uId;

   public Integer aId;

   public Goods goods;

   public User user;

   public Address address;

    public Shoppingcart(Integer sCount, Double sTotal, Integer gId, Integer uId) {
        this.sCount = sCount;
        this.sTotal = sTotal;
        this.gId = gId;
        this.uId = uId;
    }

    public Shoppingcart() {
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getsCount() {
        return sCount;
    }

    public void setsCount(Integer sCount) {
        this.sCount = sCount;
    }

    public Double getsTotal() {
        return sTotal;
    }

    public void setsTotal(Double sTotal) {
        this.sTotal = sTotal;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}