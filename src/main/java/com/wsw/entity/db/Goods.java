package com.wsw.entity.db;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import lombok.ToString;

@ToString
public class Goods {
   public Integer gId;

   public String gName;

   public Double gPrice;

   public Integer gStock;

   public String gImage;

   public String gAbout;

   public Integer tId;

   public Type type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
   public Date gDate;

   public Integer getgId() {
      return gId;
   }

   public void setgId(Integer gId) {
      this.gId = gId;
   }

   public String getgName() {
      return gName;
   }

   public void setgName(String gName) {
      this.gName = gName;
   }

   public Double getgPrice() {
      return gPrice;
   }

   public void setgPrice(Double gPrice) {
      this.gPrice = gPrice;
   }

   public Integer getgStock() {
      return gStock;
   }

   public void setgStock(Integer gStock) {
      this.gStock = gStock;
   }

   public String getgImage() {
      return gImage;
   }

   public void setgImage(String gImage) {
      this.gImage = gImage;
   }

   public String getgAbout() {
      return gAbout;
   }

   public void setgAbout(String gAbout) {
      this.gAbout = gAbout;
   }

   public Integer gettId() {
      return tId;
   }

   public void settId(Integer tId) {
      this.tId = tId;
   }

   public Type getType() {
      return type;
   }

   public void setType(Type type) {
      this.type = type;
   }

   public Date getgDate() {
      return gDate;
   }

   public void setgDate(Date gDate) {
      this.gDate = gDate;
   }
}
