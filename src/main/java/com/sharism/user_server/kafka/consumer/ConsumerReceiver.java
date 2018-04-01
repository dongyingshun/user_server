package com.sharism.user_server.kafka.consumer;

import com.sharism.user_server.kafka.beans.BeanUtils;
import com.sharism.user_server.kafka.beans.Capacity;
import com.sharism.user_server.model.UserInfo;
import com.sharism.user_server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

/**
 * @author DYS
 * @Package com.sharism.user_server.kafka.consumer
 * @Description:
 * @date 2018/3/23-17:31
 * @Version: 1.0
 */
@Component
public class ConsumerReceiver {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(this.getClass());
  /*  @KafkaListener(topics = {"test1"})
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("kafka的key: " + record.key());
        logger.info("kafka的value: " + record.value().toString());
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();
            logger.info("接收到消息："+message);
            System.out.println(message);
        }

    }*/

    @KafkaListener(topics ={"test3"})
    public void listen1( String json) {
        JSONObject obj = new JSONObject().fromObject(json);
        Capacity  value=(Capacity)JSONObject.toBean(obj,Capacity.class);
        logger.info("接收到的Capacity的flag: " +value.getFlag());
        System.out.println("接收到的Capacity的flag: " +value.getFlag());
        logger.info("接收到的Capacity的getUserId: " +value.getUserId());
        System.out.println("接收到的Capacity的getUserId: " +value.getUserId());
        logger.info("接收到的Capacity的Capacity: " +value.getCapacity());
        System.out.println("接收到的Capacity的Capacity: " +value.getCapacity());

    }
    @KafkaListener(topics = {"capacity"})
    public void capacityListener(String json) {
        JSONObject obj = new JSONObject().fromObject(json);
        Capacity  capacity=(Capacity)JSONObject.toBean(obj,Capacity.class);
        logger.info("接收到的file_server的capacity.capacity: " +capacity.getCapacity());
        logger.info("接收到的file_server的capacity.userId: " +capacity.getUserId());
        logger.info("接收到的file_server的capacity.flag: " +capacity.getFlag());
        UserInfo userInfo = new UserInfo();
        userInfo.setId(capacity.getUserId());
        userInfo.setUsedCapacity(capacity.getCapacity());
        try {
            if(capacity.getFlag()==1)
                userService.addUsedCapacity(userInfo);
            else
               userService.reduceUsedCapacity(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
