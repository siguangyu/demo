package com.consumer.config;

import com.consumer.constants.MqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/*******************************
 * * 版权所有：快服科技
 * * 创建日期: 2019/9/4 10:47
 * * 创建作者: Kevin_Ge
 * * 版本:  1.0
 * * 功能:
 * * 最后修改时间:
 * * 修改记录:
 ********************************/
@Configuration
public class RabbitConfig {

    //路由
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(MqConstants.MQ_SMS_DIRECT_EXCHANGE,true,false);
    }


    //转发队列
    @Bean
    public Queue transQueue() {
        return new Queue(MqConstants.MQ_SMS_TRANS_QUEUE, true, false, false);
    }

    @Bean
    public Queue reportPushQueue() {
        return new Queue(MqConstants.MQ_SMS_PUSH_QUEUE,true,false,false);
    }

    @Bean
    public DirectExchange reportPushExchange(){
        return new DirectExchange(MqConstants.MQ_SMS_PUSH_EXCHANGE,true,false);
    }


    //延时队列
    @Bean
    public Queue delayedLetterQueue() {
        Map<String,Object> map = new HashMap<>();
        map.put("x-dead-letter-exchange",MqConstants.MQ_SMS_DIRECT_EXCHANGE);
        map.put("x-dead-letter-routing-key",MqConstants.MQ_SMS_TRANS_KEY);
        Queue queue = new Queue(MqConstants.DELAYED_LETTER_QUEUE,true,false,false,map);
        return queue;
    }



    @Bean
    public Binding queueDeadBinding() {
        return BindingBuilder.bind(delayedLetterQueue()).to(directExchange()).with(MqConstants.DELAYED_LETTER_KEY);
    }

    @Bean
    public Binding queueTransBinding() {
        return BindingBuilder.bind(transQueue()).to(directExchange()).with(MqConstants.MQ_SMS_TRANS_KEY);
    }

    @Bean
    public Binding queueReportPushBinding(){
        return BindingBuilder.bind(reportPushQueue()).to(reportPushExchange()).with(MqConstants.MQ_SMS_PUSH_KEY);
    }


//    @Bean
//    public Queue sendTaskQueue(){
//        return new Queue(MqConstants.MQ_SMS_SEND_TASK_WEB_QUEUE,true,false,false);
//    }
//
//    @Bean
//    public DirectExchange sendTaskExchange(){
//        return new DirectExchange(MqConstants.MQ_SMS_SEND_TASK_WEB_EXCHANGE,true,false);
//    }
//
//    @Bean
//    public Binding queueSendTaskBinding(){
//        return BindingBuilder.bind(sendTaskQueue()).to(reportPushExchange()).with(MqConstants.MQ_SMS_SEND_TASK_WEB_KEY);
//    }


//    @Bean("smsSendTaskCustomContainerFactory")
//    public SimpleRabbitListenerContainerFactory containerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConcurrentConsumers(10);  //设置线程数
//        factory.setMaxConcurrentConsumers(10); //最大线程数
//        configurer.configure(factory, connectionFactory);
//        return factory;
//    }
}
