package com.wsw.entity.db;

import lombok.ToString;

@ToString
public class Address {

   public Integer aId;

   public String aAddr;

   public String aSenduser;

   public String aDetail;

   public String aSendtel;

   public Integer uId;

   public int aState;

   public User user;

   public Integer getaId() {
      return aId;
   }

   public void setaId(Integer aId) {
      this.aId = aId;
   }

   public String getaAddr() {
      return aAddr;
   }

   public void setaAddr(String aAddr) {
      this.aAddr = aAddr;
   }

   public String getaSenduser() {
      return aSenduser;
   }

   public void setaSenduser(String aSenduser) {
      this.aSenduser = aSenduser;
   }

   public String getaDetail() {
      return aDetail;
   }

   public void setaDetail(String aDetail) {
      this.aDetail = aDetail;
   }

   public String getaSendtel() {
      return aSendtel;
   }

   public void setaSendtel(String aSendtel) {
      this.aSendtel = aSendtel;
   }

   public Integer getuId() {
      return uId;
   }

   public void setuId(Integer uId) {
      this.uId = uId;
   }

   public int getaState() {
      return aState;
   }

   public void setaState(int aState) {
      this.aState = aState;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }
}
