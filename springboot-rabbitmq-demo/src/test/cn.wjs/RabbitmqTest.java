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
        String queueName = "moliQueue";
        String message = "hello world 哈哈";
        rabbitTemplate.convertAndSend("moliExchange", queueName, message);

    }
    @Test
    public void receiveTest(){
        String queueName = "moliQueue";

        System.out.println("消费消息: " + rabbitTemplate.receiveAndConvert(queueName));

    }
}
