package cn.wjs.send.mqconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class DeadLetterRabbitMQConfig {

//    final String CHAT_DEAD_LETTER_EXCHANGE = "chat.dead.letter.exchange";
//
//    final String CHAT_DEAD_ROUTING_KEY = "chat.dead.letter.key";
//
//    final String CHAT_DEAT_LETTER_QUEUE = "chat.dead.letter.queue";
//
//    // 创建交换机
//    @Bean
//    DirectExchange deadLetterExchange() {
//        return new DirectExchange(CHAT_DEAD_LETTER_EXCHANGE, true, false);
//    }
//
//    // 创建死信队列
//    @Bean
//    Queue deadLetterQueue() {
//        return new Queue(CHAT_DEAT_LETTER_QUEUE, true);
//    }
//
//    // 绑定队列和交换机
//    @Bean
//    Binding deadLetterBinding() {
//        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with(CHAT_DEAD_ROUTING_KEY);
//    }


//    @Bean
//    public Queue maintainQueue() {
//        Map<String, Object> args = new HashMap<String, Object>();
//        args.put("x-dead-letter-exchange", CHAT_DEAD_LETTER_EXCHANGE);
//        args.put("x-dead-letter-routing-key", CHAT_DEAD_ROUTING_KEY);
//        return new Queue(DEAD_ROUTING_KEY, true, false, false, args);
//    }
//
//    @Bean
//    public Binding maintainBinding() {
//        return BindingBuilder.bind(maintainQueue()).to(DirectExchange.DEFAULT).with(DEAD_ROUTING_KEY);
//    }

//    @Bean
//    public Queue deadLetterQueue() {
//        return new Queue(DEAD_ROUTING_KEY);
//    }
//
//    @Bean
//    public DirectExchange deadLetterExchange() {
//        return new DirectExchange(DEAD_LETTER_EXCHANGE, true, false);
//    }
//
//    @Bean
//    public Binding deadLetterBinding() {
//        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with(DEAD_ROUTING_KEY);
//    }

}
