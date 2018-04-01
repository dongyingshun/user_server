package com.sharism.user_server.controller;

import com.sharism.user_server.kafka.beans.BeanUtils;
import com.sharism.user_server.kafka.beans.Capacity;
import com.sharism.user_server.kafka.producer.ProducerSender;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @author DYS
 * @Package com.sharism.user_server.controller
 * @Description:
 * @date 2018/3/24-16:44
 * @Version: 1.0
 */

@RestController
@RequestMapping("/kafka")
public class KafkaTestController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendKafka(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 0; i < 10; i++) {
            //调用消息发送类中的消息发送方法
            JSONObject obj =JSONObject.fromObject(new Capacity(20,"abc123",1));

            kafkaTemplate.send("test3",obj.toString());
            System.out.println("user_server发出了一个消息");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            String message = request.getParameter("message");
            logger.info("kafka发送的消息={}",message);
            kafkaTemplate.send("test3", "key", message);
            //logger.info("发送kafka成功.");
            return message;
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            return "发送kafka失败";
        }
    }

}