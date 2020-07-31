/*
 * @(#) TestException
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2019
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author 温思伟
 * <br> 2019-09-23 16:03:25
 */

package com.wsw;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Callable;

public class TestException {
    static {
        Exception e=new IOException();
        try {
            FileInputStream in = new FileInputStream(new File("D:/1.JPG"));
        /*     new Callable<Object>(new Thread(){
                 @Override
                 public void run(){}

             });*/

        }catch (IOException e2){
            //通过日志打印的形式实现错误的查找与修改
            Log log=new Log4JLogger();
            log.error("文件未找到！",e);
        }
    }

}
