package com.ruoyi.web.controller.bigdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.ruoyi.web.controller.ClusterTraffic;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：Gavin
 * Datetime : 2021/5/12 14:26
 */
public class Json {
    public static void main(String[] args) {

        List<ClusterTraffic> clusterTraffics = new ArrayList<>();
        ClusterTraffic clusterTraffic = new ClusterTraffic(116.0,39.0,10L,"上海路");
        ClusterTraffic clusterTraffic2 = new ClusterTraffic(116.0,39.5,10L,"南京路");
        clusterTraffics.add(clusterTraffic);clusterTraffics.add(clusterTraffic2);

        String json = JSONArray.toJSONString(clusterTraffics);
        System.out.println(json);
        List<ClusterTraffic> clusterTrafficss = JSON.parseObject(json, new TypeReference<List<ClusterTraffic>>() {});
        System.out.println(clusterTrafficss.size());
        clusterTrafficss.forEach(a-> System.out.println(a.toString()));

    }
}
