
package com.wsw.entity.db;

import lombok.ToString;

@ToString
public class Type {

   public Integer tId;

   public String tName;

   public Integer gettId() {
      return tId;
   }

   public void settId(Integer tId) {
      this.tId = tId;
   }

   public String gettName() {
      return tName;
   }

   public void settName(String tName) {
      this.tName = tName;
   }
}
