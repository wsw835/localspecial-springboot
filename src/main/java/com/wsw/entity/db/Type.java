/*
 * @(#) Type
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