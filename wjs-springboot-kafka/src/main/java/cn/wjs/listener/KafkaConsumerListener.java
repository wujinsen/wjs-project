package cn.wjs.listener;


import cn.wjs.controller.Student;
import cn.wjs.controller.User;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.JstlUtils;

@Component
@Slf4j
public class KafkaConsumerListener {


    @KafkaListener(groupId = "student", topics = "student")
    public void listenUserStr(String str) {
        Student student = JSON.parseObject(str, Student.class);
        log.info("消费数据====================: {}", str);
        log.info("消费数据====================student: {}", student);
    }

//    @KafkaListener(id = "userGroup", topics = "topic-user")
//    public void listenUser(User user) {
//        log.info("消费数据: {}", user);
//    }

//    @KafkaListener(id = "userGroup", topics = "aaa_topic")
//    public void listenUser(String str) {
//        log.info("消费数据: {}", str);
//    }

}
