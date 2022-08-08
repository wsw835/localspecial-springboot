
package com.wsw.entity.vo;

import java.util.List;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
public class HistoryVO {
   public String uname;
   public String keyword;
   public List<String> list;
}
