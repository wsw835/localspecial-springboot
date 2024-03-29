package com.wsw.entity.db;

import java.util.Date;

import lombok.ToString;

@ToString
public class Comments {
   public Integer cId;
   public String cComment;
   public Integer uId;
   public Integer gId;
   public Date cDate;
   public User user;
   public Goods goods;

   public Integer getcId() {
      return cId;
   }

   public void setcId(Integer cId) {
      this.cId = cId;
   }

   public String getcComment() {
      return cComment;
   }

   public void setcComment(String cComment) {
      this.cComment = cComment;
   }

   public Integer getuId() {
      return uId;
   }

   public void setuId(Integer uId) {
      this.uId = uId;
   }

   public Integer getgId() {
      return gId;
   }

   public void setgId(Integer gId) {
      this.gId = gId;
   }

   public Date getcDate() {
      return cDate;
   }

   public void setcDate(Date cDate) {
      this.cDate = cDate;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public Goods getGoods() {
      return goods;
   }

   public void setGoods(Goods goods) {
      this.goods = goods;
   }
}
