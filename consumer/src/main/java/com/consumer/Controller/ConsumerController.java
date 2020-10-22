package com.consumer.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.api.core.Test;
import com.consumer.constants.MqConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sigy
 * @Date: 2020/9/15 17:30
 */

@RestController
@RequestMapping("controller")
public class ConsumerController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //    @Reference(url = "dubbo://localhost:20999")
    @Reference
    private Test test;


    @RequestMapping("/test")
    public void test() {
        test.test("哈哈");
        System.out.println("开始推送");
//        rabbitTemplate.convertAndSend("exchange-gzk", "route_gzk", "++++++++++++++++++++++++++" );
        /*rabbitTemplate.convertAndSend("exchange-delayed", "delayed", "延迟队列", message -> {
            message.getMessageProperties().setExpiration(String.valueOf(5000));
            return message;
        });*/
        rabbitTemplate.convertAndSend(MqConstants.MQ_SMS_DIRECT_EXCHANGE, MqConstants.DELAYED_LETTER_KEY, "延时队列测试", message -> {
            message.getMessageProperties().setExpiration(String.valueOf(5000));
            return message;
        });
    }
}
