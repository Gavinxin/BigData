package com.ruoyi.web;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author：Gavin
 * Datetime : 2021/5/11 19:33
 */

@Configuration
public class KafkaInitialConfiguration {
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("testtopic",3, (short) 2 );
    }

    // 如果要修改分区数，只需修改配置值重启项目即可
    // 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
    @Bean
    public NewTopic updateTopic() {
        return new NewTopic("testtopic",3, (short) 2 );
    }

}
