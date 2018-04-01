package com.sharism.user_server.kafka.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DYS
 * @Package com.sharism.user_server.kafka.beans
 * @Description:
 * @date 2018/3/23-15:26
 * @Version: 1.0
 */
@Configuration
@EnableKafka
public class KafkaProducerConfig {

   // @Value("${kafka.bootstrap.servers}")
    private String servers="118.25.46.139:9092";
   // @Value("${kafka.producer.retries}")
   // private int retries;
   // @Value("${kafka.producer.batch.size}")
   // private int batchSize;
   // @Value("${kafka.producer.linger}")
   // private int linger;
   // @Value("${kafka.producer.buffer.memory}")
   // private int bufferMemory;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        //props.put(ProducerConfig.RETRIES_CONFIG, retries);
        //props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        // props.put(ProducerConfig.LINGER_MS_CONFIG, linger);
        // props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<String, String>(producerFactory());
    }
}