package com.ruoyi.web.controller.bigdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.ClusterHistory;
import com.ruoyi.system.service.IClusterHistoryService;
import com.ruoyi.web.config.WebSocketServer;
import com.ruoyi.web.controller.ClusterTraffic;
import org.apache.commons.math3.analysis.function.Add;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

@Controller
@RequestMapping("/bigdata")
@Component
public class MonitorController {

    private Double pStartX;

    private Double pStartY;

    private Double pEndX;

    private Double pEndY;
    @Autowired
    public WebSocketServer webSocketServer;

    @Autowired
    public IClusterHistoryService iClusterHistoryService;

    @GetMapping("/monitor")
    public String main()
    {

        return "main";
    }

    @GetMapping("/limit")
    @ResponseBody
    public AjaxResult limit(Double pStartX,Double pStartY,Double pEndX,Double pEndY)
    {
        this.pEndX = pEndX;
        this.pStartX = pStartX;
        this.pStartY = pStartY;
        this.pEndY = pEndY;
        AjaxResult ajaxResult =new AjaxResult(AjaxResult.Type.SUCCESS,"成功");
        return ajaxResult;
    }

    @KafkaListener(topics = {"gpstracks"})
    public void listen(ConsumerRecord<?, ?> record) throws Exception {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        List<ClusterTraffic> clusterTraffics = JSON.parseObject(kafkaMessage.get().toString(), new TypeReference<List<ClusterTraffic>>() {});
        Collections.sort(clusterTraffics);
        List<ClusterTraffic> clusterTrafficResult = new ArrayList<>();
        for (ClusterTraffic c: clusterTraffics) {
            c.setRoadName(Address.getAddress(c.getLat(),c.getLon()));
            c.setName(Address.getAddress(c.getLat(),c.getLon()));
            c.setTime(new Date());
            iClusterHistoryService.insertClusterHistory(c);
            if(clusterTrafficResult.size()<8){
                clusterTrafficResult.add(c);
            }
        }
        if(this.pEndX!=null && this.pEndY!=null&this.pStartX!=null&&this.pStartY!=null){
            for (ClusterTraffic c: clusterTraffics) {
                if(clusterTrafficResult.size()<8){
                    clusterTrafficResult.add(c);
                }
            }
        }
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("数据接收完毕："+message);
            System.out.println(JSON.toJSONString(clusterTrafficResult));
            webSocketServer.sendInfo(JSON.toJSONString(clusterTrafficResult),"100");
        }
    }

}
