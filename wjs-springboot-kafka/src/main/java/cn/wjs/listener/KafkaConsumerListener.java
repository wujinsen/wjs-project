package cn.wjs.listener;


import cn.wjs.controller.User;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerListener {


//    @KafkaListener(id = "userGroup", topics = "topic-user")
//    public void listenUserStr(String str) {
//        User user = JSON.parseObject(str, User.class);
//        log.info("消费数据: {}", user);
//    }

    @KafkaListener(id = "userGroup", topics = "topic-user")
    public void listenUser(User user) {
        log.info("消费数据: {}", user);
    }

//    @KafkaListener(id = "dltGroup", topics = "topic1.DLT")
//    public void dltListen(String in) {
//        log.info("Received from DLT: " + in);
//    }

}
