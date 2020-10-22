package com.provider.core.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.IOException;
import java.util.Map;

@Slf4j
//@Component
public class TestSyncMsgReceiver {
       
    
    /**
     * 同步
     * @param content
     * @throws IOException
     */
//    @RabbitListener(
//            bindings = @QueueBinding(
//                    value = @Queue(value = "order-queue-gzk", durable = "true", autoDelete="true"),
//                    exchange = @Exchange(name = "exchange-lee", autoDelete="true"),
//                    file = "sync_route_test"))
    @RabbitHandler
    public String processSync(@Payload String content, @Headers Map<String, Object> headers, Channel channel)
            throws IOException {
        log.info("同步接收到消息： " + content);

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        boolean multiple = false;

        channel.basicAck(deliveryTag, multiple);
        
        return "received one.";
    }
}
