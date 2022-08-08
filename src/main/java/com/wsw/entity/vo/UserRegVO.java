package com.wsw.entity.vo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
public class UserRegVO {

   public String uName;
   public String uRealName;
   public String uTel;
   public String password;
   public String checkPassword;

}
