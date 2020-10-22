package com.consumer.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class TestAsyncMsgReceiver1 {
        
   /* // 如果exchange和queue不存在，由@RabbitListener的bindings生成
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "order-queue-gzk", durable = "true", autoDelete="false"),
                    exchange = @Exchange(name = "exchange-gzk", autoDelete="false"),
                    key = "route_gzk"))
//    @RabbitHandler
    public void process(@Payload String content, @Headers Map<String, Object> headers, Channel channel)
            throws IOException, InterruptedException {
        log.info("consumer异步接收到消息： " + content);
        *//**
         * Delivery Tag 用来标识信道中投递的消息。RabbitMQ 推送消息给 Consumer 时，会附带一个 Delivery Tag， 以便
         * Consumer 可以在消息确认时告诉 RabbitMQ 到底是哪条消息被确认了。 RabbitMQ 保证在每个信道中，每条消息的 Delivery
         * Tag 从 1 开始递增。
         *//*
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        *//**
         * multiple 取值为 false 时，表示通知 RabbitMQ 当前消息被确认 如果为 true，则额外将比第一个参数指定的 delivery
         * tag 小的消息一并确认
         *//*
        boolean multiple = false;

        channel.basicAck(deliveryTag, multiple);
        Thread.currentThread().sleep(1000);

    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "order-queue-gzk2", durable = "true", autoDelete="false"),
                    exchange = @Exchange(name = "exchange-gzk2", autoDelete="false"),
                    key = "route_gzk"))
//    @RabbitHandler
    public void process2(@Payload String content, @Headers Map<String, Object> headers, Channel channel)
            throws IOException, InterruptedException {
        log.info("异步接收到消息2： " + content);
        *//**
         * Delivery Tag 用来标识信道中投递的消息。RabbitMQ 推送消息给 Consumer 时，会附带一个 Delivery Tag， 以便
         * Consumer 可以在消息确认时告诉 RabbitMQ 到底是哪条消息被确认了。 RabbitMQ 保证在每个信道中，每条消息的 Delivery
         * Tag 从 1 开始递增。
         *//*
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        *//**
         * multiple 取值为 false 时，表示通知 RabbitMQ 当前消息被确认 如果为 true，则额外将比第一个参数指定的 delivery
         * tag 小的消息一并确认
         *//*
        boolean multiple = false;
        channel.basicAck(deliveryTag, multiple);
        Thread.currentThread().sleep(1000);
    }

*/


}
