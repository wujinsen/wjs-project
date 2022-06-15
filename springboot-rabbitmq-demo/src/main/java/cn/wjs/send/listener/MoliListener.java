package cn.wjs.send.listener;

import cn.wjs.model.User;
import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MoliListener {

//    @RabbitListener(queues = {"moliQueue"})
//    public void listenMoliQueue(Message msg) throws Exception {
//
//        System.out.println("moliQueue moli监听消息: " + msg);
//        System.out.println("具体消息： " + new String(msg.getBody(), "UTF-8"));
//
//    }
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

    @RabbitListener(queues = {"gift.send.room"})
    @RabbitHandler
    public void listenMoliQueue3(@Payload Message msg) throws Exception {
       // User user = JSON.parseObject(msg.getBody(), User.class);
        System.out.println("moliQueue3 moli监听消息: " + msg);
       // System.out.println("具体消息: " + JSON.toJSONString(user));
    }


}

