//package cn.wjs.send.mqconfig;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//
//
//
//@Configuration
//public class BusinessRabbitMQConfig {
//
//    // 创建交换机
//    @Bean
//    DirectExchange businessExchange() {
//        return new DirectExchange("business.exchange", true, false);
//    }
//
//    // 创建业务消息队列
//    @Bean
//    Queue businessQueue1() {
//        HashMap<String, Object> args = new HashMap<String, Object>();
//        // 设置死信交换机
//        args.put("x-dead-letter-exchange", "dead.letter.exchange");
//        // 设置死信交换机绑定队列的routingKey
//        args.put("x-dead-letter-routing-key", "dead.letter");
//        return new Queue("business.queue1", true, false, false, args);
//    }
//
//    @Bean
//    Binding businessBinding1() {
//        return BindingBuilder.bind(businessQueue1()).to(businessExchange()).with("business1");
//    }
//
//}
