package cn.wjs.producer;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Log
@Component
public class KafkaProducer {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.user}")
    private String topicUser;//topic名称

    /**
     * 发送用户消息
     *
     * @param user 用户信息
     */
    public void sendUserMessage(User user) {

        String message = JSONObject.toJSONString(user);
        kafkaTemplate.send(topicUser, message);
        log.info("\n生产消息至Kafka\n" + message);
    }

    /**
     * 发送用户消息
     *
     * @param student 用户信息
     */
    public void sendStudentMessage(Student student) {

        String message = JSONObject.toJSONString(student);
        kafkaTemplate.send("student", message);
        log.info("\n生产消息至Kafka\n" + message);
    }
}
