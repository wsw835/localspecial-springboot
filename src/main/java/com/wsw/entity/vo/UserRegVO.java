/*
 * @(#) UserRegVO
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2019
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author 温思伟
 * <br> 2019-11-23 10:44:57
 */

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
