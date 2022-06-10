package cn.wjs.send.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MoliListener {

    @RabbitListener(queues = {"moliQueue"})
    public void listenMoliQueue(Message msg) throws Exception {

        System.out.println("moliQueue moli监听消息: " + msg);
        System.out.println("具体消息： " + new String(msg.getBody(), "UTF-8"));

    }

    //@RabbitListener(queues = {"moliQueue2"})
    public void listenMoliQueue2(Message msg) throws Exception {

        System.out.println("moliQueue2 moli监听消息: " + msg);
        System.out.println("具体消息： " + new String(msg.getBody(), "UTF-8"));

    }

}

