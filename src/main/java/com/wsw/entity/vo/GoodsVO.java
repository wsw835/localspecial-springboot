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
