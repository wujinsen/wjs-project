package cn.wjs;


import cn.wjs.domain.OrderM;
import cn.wjs.mapper.OrderMapper;
import cn.wjs.service.OrderServer;
import cn.wjs.util.GenerateRandom;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMTest {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderServer orderServer;

    @Autowired
    private RedissonClient redissonClient;


    @Test
    public void insertTest() {
        OrderM order = new OrderM();
        order.setId(Long.valueOf(GenerateRandom.number(6)));
        order.setUserId(1l);
        order.setSkuId(1l);
        order.setOrderNo("123456");
        order.setCreateTime(new Date());
        orderMapper.insert(order);
    }

    @Test
    public void oversoldTest() {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        Long skuId = 1l;
        List<CompletableFuture<Boolean>> result = list.stream().map(e -> CompletableFuture.completedFuture(e).thenApply(next -> {
            Boolean b = orderServer.createOrder(Long.valueOf(next), skuId);
            System.out.println("用户id: " + next + " 抢购结果: " + b);
            return b;
        })).collect(Collectors.toList());

        CompletableFuture.allOf(result.toArray(new CompletableFuture[result.size()])).join();

    }

    @Test
    public void lockTest() {
        /**  如果不加锁，必然超卖 **/
        RLock lock = redissonClient.getLock("bbb:" + 123);
        //   lock.lock(10, TimeUnit.SECONDS);
        lock.lock();
        System.out.println(lock.isLocked());

    }

    public void test(){

    }

}

