/*
 * @(#) TestRedis
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2019
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author 温思伟
 * <br> 2019-09-23 14:23:03
 */
package com.wsw;

import com.wsw.service.SearchHistoryService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRedis {
    private static SearchHistoryService s = new SearchHistoryService();

    @Test
    public void getInf(){
        List list=new ArrayList();
        String  a="abc";
        String  b="";
        for(int i=a.length()-1;i>=0;i--){
            b+=a.charAt(i);
        }
        System.out.println(b);
    }


    @Test
    public void get() {
        String a="123";
        s.updateList(1, "葡萄");
        s.updateList(1, "肉干");
        s.updateList(1, "肉片");
        s.updateList(1, "水果");
        List<String> list = s.getAutoMatchs(1, null);
        for(String x:list){
           System.out.println(x);
       }

    }
}
