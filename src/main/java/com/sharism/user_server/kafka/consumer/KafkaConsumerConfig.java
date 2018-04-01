package com.sharism.user_server.kafka.consumer;

import org.apache.kafka.clients.Metadata.Listener;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author DYS
 * @Package com.sharism.user_server.kafka.beans
 * @Description:
 * @date 2018/3/23-16:17
 * @Version: 1.0
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    //@Value("${kafka.bootstrap.servers}")
    private String servers="118.25.47.192:9092";
   // @Value("${kafka.consumer.enable.auto.commit}")
    //private boolean enableAutoCommit;
    //@Value("${kafka.consumer.session.timeout}")
    //private String sessionTimeout;
    //@Value("${kafka.consumer.autoCommitInterval}")
    //private String autoCommitInterval;
    // @Value("${kafka.consumer.group.id}")
      private String groupId  ="foo";
    //@Value("${kafka.consumer.auto.offset.reset}")
    //private String autoOffsetReset;
    //@Value("${kafka.consumer.concurrency}")
    //private int concurrency;
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
     //   factory.setConcurrency(concurrency);
        factory.getContainerProperties().setPollTimeout(1500);
        return factory;
    }
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        //propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        //propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
        //propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        //propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        return propsMap;
    }
    @Bean
    public ConsumerReceiver listener() {
        return new ConsumerReceiver();
    }

}