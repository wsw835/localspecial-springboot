/*
 * @(#) GoodsVO
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2019
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author 温思伟
 * <br> 2019-11-23 10:44:57
 */

package com.wsw.entity.vo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
public class GoodsVO {

   public String name;
   public Double price;
   public Integer store;
   public MultipartFile image;
   public String about;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
   public Date date;
   public int typeId;
}
