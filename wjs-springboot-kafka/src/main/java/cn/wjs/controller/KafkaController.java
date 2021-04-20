package cn.wjs.controller;

import cn.wjs.consumer.KafkaConsumerDemo;
import cn.wjs.producer.KafkaProducer;
import cn.wjs.producer.Student;
import cn.wjs.producer.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 测试控制器
 * PS:@RestController 注解： 该注解是 @Controller 和 @ResponseBody 注解的合体版
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaConsumerDemo kafkaConsumerDemo;

    @RequestMapping("/createMsg")
    public void createMsg() {
        User user = new User();
        user.setId(new Random().nextInt(100));
        user.setName("aa");
        user.setAge(18);
        kafkaProducer.sendUserMessage(user);
    }
    @RequestMapping("/createStudentMsg")
    public void createStudentMsg() {
        Student student = new Student();
        student.setId(new Random().nextInt(100));
        student.setName("王五");
        student.setAge(20);
      //  student.setPassword("123");
        kafkaProducer.sendStudentMessage(student);
    }
    @RequestMapping("/readMsg")
    public void readMsg() {
        kafkaConsumerDemo.consume();
    }

}
