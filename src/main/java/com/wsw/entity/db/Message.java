package com.wsw.entity.db;


import lombok.ToString;

@ToString
public class Message {
   public String message;

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }
}
