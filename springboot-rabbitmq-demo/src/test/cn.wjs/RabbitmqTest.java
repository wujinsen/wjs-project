package cn.wjs;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTest {

    @Resource
    private RabbitTemplate rabbitTemplate;


    @Test
    public void sendTest(){
        String routingKey = "moliKey";
        String message = "hello world 哈哈";
        String routingKey2 = "moliKey2";
        String message2 = "hello world 2号";
        rabbitTemplate.convertAndSend("moliExchange", routingKey, message);

        rabbitTemplate.convertAndSend("moliExchange", routingKey2, message2);
    }

    @Test
    public void receiveTest(){
        String queueName = "moliQueue";

        System.out.println("消费消息: " + rabbitTemplate.receiveAndConvert(queueName));

    }

    @Test
    public void sendTopicTest(){
        String routingKey = "order.1";
        String message = "hello world order1";
        String routingKey2 = "order.2";
        String message2 = "hello world order2";
        rabbitTemplate.convertAndSend("moli_topic_exchange", routingKey, message);
        rabbitTemplate.convertAndSend("moli_topic_exchange", routingKey2, message2);
    }
}
