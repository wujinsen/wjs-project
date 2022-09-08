package cn.wjs.listener;


import cn.wjs.controller.User;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerListener {


    @KafkaListener(id = "audit", topics = "spa_user_pointdata_beta_topic")
    public void listenUserStr(String str) {
      //  User user = JSON.parseObject(str, User.class);
        log.info("消费数据====================: {}", str);
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
