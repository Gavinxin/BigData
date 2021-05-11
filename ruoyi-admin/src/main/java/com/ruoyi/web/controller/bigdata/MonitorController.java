package com.ruoyi.web.controller.bigdata;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.web.controller.ClusterTraffic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bigdata")
@Component
public class MonitorController {
    @GetMapping("/monitor")
    public List<ClusterTraffic> main()
    {

        return "main";
    }

    @GetMapping("/limit")
    @ResponseBody
    public List<ClusterTraffic> limit()
    {
        List<ClusterTraffic>  = listen()

    }

    @KafkaListener(topics = {"gpstracks"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("数据接收完毕："+message);
        }
    }

}
