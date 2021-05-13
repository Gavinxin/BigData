package com.ruoyi.web.controller.bigdata;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：Gavin
 * Datetime : 2021/5/12 17:23
 */
public class Address {

    public final static String KEY = "bf6c1511105c688f03045f55c10a4b71";


    public static String getAddress(Double lat, Double lon) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求

        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        list.add(new BasicNameValuePair("key", KEY));
        list.add(new BasicNameValuePair("location", lat+","+lon));
        list.add(new BasicNameValuePair("poitype", "道路交叉路口"));
        list.add(new BasicNameValuePair("radius", "1000"));
        //list.add(new BasicNameValuePair("extensions", "base"));
        //3、转化参数
        String params = EntityUtils.toString(new UrlEncodedFormEntity(list, Consts.UTF_8));
        HttpGet httpGet = new HttpGet("https://restapi.amap.com/v3/geocode/regeo?"+params);
        System.out.println(params);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String message = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.parseObject(message);
        JSONObject rego = (JSONObject) jsonObject.get("regeocode");
        return rego.get("formatted_address").toString();
    }

}
