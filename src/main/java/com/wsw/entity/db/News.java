package com.wsw.entity.db;

import java.util.Date;

import lombok.ToString;

@ToString
public class News {
   public Integer nId;

   public Date nDate;

   public String nTitle;

   public String nContent;

   public String nImage;

   public Integer uId;

   public Integer getnId() {
      return nId;
   }

   public void setnId(Integer nId) {
      this.nId = nId;
   }

   public Date getnDate() {
      return nDate;
   }

   public void setnDate(Date nDate) {
      this.nDate = nDate;
   }

   public String getnTitle() {
      return nTitle;
   }

   public void setnTitle(String nTitle) {
      this.nTitle = nTitle;
   }

   public String getnContent() {
      return nContent;
   }

   public void setnContent(String nContent) {
      this.nContent = nContent;
   }

   public String getnImage() {
      return nImage;
   }

   public void setnImage(String nImage) {
      this.nImage = nImage;
   }

   public Integer getuId() {
      return uId;
   }

   public void setuId(Integer uId) {
      this.uId = uId;
   }
}
