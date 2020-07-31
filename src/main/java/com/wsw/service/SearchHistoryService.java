package com.wsw.service;

import com.wsw.util.JedisUtil;
import redis.clients.jedis.Pipeline;

import java.util.ArrayList;
import java.util.List;

//从搜索历史列表中获取匹配的列表以及搜索历史的更新
public class SearchHistoryService {

    private static JedisUtil jedisUtil = new JedisUtil();

    /**
     * 更新搜索历史列表
     * @param userId    用户id
     * @param searchkey 本次搜索关键词
     */
    public void updateList(Integer userId, String searchkey) {
        String key = String.valueOf(userId);
        //为了保证事务和性能，采用pipeline
        Pipeline pipeline = jedisUtil.init().pipelined();
        pipeline.lrem(key, 1, searchkey);//如果该关键词已存在先删除
        pipeline.lpush(key, searchkey);//把该关键词放在最顶部（左边）
        pipeline.ltrim(key, 0, 4);//裁剪list 保留最近的5个关键词
        pipeline.sync();//批量提交命令
    }

    /**
     * 从搜索历史列表中获取匹配的列表
     * @param userId
     * @param pre
     * @return
     */
    public List getAutoMatchs(Integer userId, String pre) {
        String key = String.valueOf(userId);
        //获取该用户对应的“搜索历史列表”
        List<String> all = jedisUtil.init().lrange(key, 0, -1);
        if (all==null) {
            return null;
        }
        else if (pre != null && pre.length() > 0) {
            List<String> matchList = new ArrayList<>();
            for (String one : all) {
                //前缀匹配
                if (one.startsWith(pre)) {
                    matchList.add(one);
                }
            }
            return matchList;//返回匹配到的“搜索历史列表”
        } else {
            return all;//用户还没有输入，就返回所有的“搜索历史列表”
        }
    }
}

