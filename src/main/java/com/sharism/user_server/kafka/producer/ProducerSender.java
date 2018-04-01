package com.sharism.user_server.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author DYS
 * @Package com.sharism.user_server.kafka.producer
 * @Description:
 * @date 2018/3/23-17:08
 * @Version: 1.0
 */
@Component
public class ProducerSender {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topic,Object objectj) {

       kafkaTemplate.send(topic, objectj);
    }
}
