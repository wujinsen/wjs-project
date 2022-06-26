package cn.wjs.send.mqconfig;

import cn.wjs.model.User;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MoliListener {


    @RabbitListener(queues = {"moliQueue"})
    public void listenMoliQueue(Message msg) throws Exception {

        System.out.println("moliQueue moli监听消息: " + msg);
        System.out.println("具体消息： " + new String(msg.getBody(), "UTF-8"));

    }
//
//    //@RabbitListener(queues = {"moliQueue2"})
//    public void listenMoliQueue2(Message msg) throws Exception {
//
//        System.out.println("moliQueue2 moli监听消息: " + msg);
//        System.out.println("具体消息： " + new String(msg.getBody(), "UTF-8"));
//
//    }
//
//    @RabbitListener(queues = {"moliQueue4"})
//    @RabbitHandler
//    public void listenMoliQueue3(@Payload Message msg) throws Exception {
//        User user = JSON.parseObject(msg.getBody(), User.class);
//        System.out.println("moliQueue3 moli监听消息: " + msg);
//        System.out.println("具体消息: " + JSON.toJSONString(user));
//    }

//    @RabbitListener(queues = {"moli4"})
//    @RabbitHandler
//    public void listenMoliQueue3(@Payload Message msg) throws Exception {
//
//        System.out.println("moliQueue4 moli监听消息: " + msg);
//
//        try{
//            User user = JSON.parseObject(msg.getBody(), User.class);
//        }catch (Exception e){
//            System.out.println("=========: " + e);
//            throw  new Exception();
//        }
//       // System.out.println("具体消息: " + JSON.toJSONString(user));
//    }

    /**
     * 死信队列
     * @param msg
     * @throws Exception
     */
    @RabbitListener(queues = {"moli4"})
    @RabbitHandler
    public void listenMoli4(@Payload Message msg, Channel channel) throws Exception {

        System.out.println("moli4 moli监听消息: " + msg);

        try{
            User user = JSON.parseObject(msg.getBody(), User.class);
        }catch (Exception e){
            System.out.println("=========: " + e);
            channel.basicNack(msg.getMessageProperties().getDeliveryTag(), false,false);
        }
        channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
        // System.out.println("具体消息: " + JSON.toJSONString(user));
    }

}

