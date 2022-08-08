package com.wsw.entity.db;

import java.util.Date;
import java.util.List;

import lombok.ToString;

@ToString
public class Order {
   public Integer orId;

   public Date orDate;

   public Integer gId;

   public Integer uId;

   public Double orTotal;

   public Integer orCount;

   public Integer orState;

   public Integer aId;

   public Address address;

   public Goods good;

   public User user;

   public List<Orderdetail> orderdetailList;

    public Order(Integer orId, Integer gId, Integer uId, Integer orCount, Double orTotal) {
        this.orId = orId;
        this.gId = gId;
        this.uId = uId;
        this.orCount = orCount;
        this.orTotal = orTotal;
    }

    public Order() {

    }

    public Integer getOrId() {
        return orId;
    }

    public void setOrId(Integer orId) {
        this.orId = orId;
    }

    public Date getOrDate() {
        return orDate;
    }

    public void setOrDate(Date orDate) {
        this.orDate = orDate;
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

    public Double getOrTotal() {
        return orTotal;
    }

    public void setOrTotal(Double orTotal) {
        this.orTotal = orTotal;
    }

    public Integer getOrCount() {
        return orCount;
    }

    public void setOrCount(Integer orCount) {
        this.orCount = orCount;
    }

    public Integer getOrState() {
        return orState;
    }

    public void setOrState(Integer orState) {
        this.orState = orState;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Orderdetail> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(List<Orderdetail> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }
}
