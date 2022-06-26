package cn.wjs;


import cn.wjs.model.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.springframework.amqp.core.MessageDeliveryMode;
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
    //接受消息
    @Test
    public void receiveTest(){
        String queueName = "moliQueue";

        System.out.println("消费消息: " + rabbitTemplate.receiveAndConvert(queueName));

    }

    //发送topic消息
    @Test
    public void sendTopicTest(){
        String routingKey = "order";
        String message = "hello world order1";
        String routingKey2 = "order.2";
        String message2 = "hello world order2";
        rabbitTemplate.convertAndSend("moli_topic_exchange", routingKey, message);
       // rabbitTemplate.convertAndSend("moli_topic_exchange", routingKey2, message2);
    }

    @Test
    public void sendUserTest() {
        User user = new User();
        user.setId(1);
        user.setName("aaa");
        rabbitTemplate.convertAndSend("moliExchange", "moliUser", JSON.toJSONString(user));

    }

    @Test
    public void sendUserTest2() {
        User user = new User();
        user.setId(1);
        user.setName("aaa");
//        rabbitTemplate.convertAndSend("moliExchange", "moli4", JSON.toJSONString(user));
        rabbitTemplate.convertAndSend("moliExchange", "moli4Key",
                JSON.toJSONString(user), message -> {
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    message.getMessageProperties().setExpiration("10000");
                    return message;
                });

    }



}
