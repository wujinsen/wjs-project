package cn.wjs.service;

import cn.wjs.domain.OrderM;
import cn.wjs.domain.Stock;
import cn.wjs.mapper.OrderMapper;
import cn.wjs.mapper.StockMapper;
import cn.wjs.util.GenerateRandom;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class OrderServerImpl implements OrderServer {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StockService stockService;

    @Transactional(rollbackFor = Exception.class)
    public boolean createOrder(Long userId, Long skuId) {

        /**  如果不加锁，必然超卖 **/
        RLock lock = redissonClient.getLock("stock:" + skuId);

        try {
            lock.lock(10, TimeUnit.SECONDS);
            int stockNum = stockMapper.selectOne(new LambdaQueryWrapper<Stock>().eq(Stock::getSkuId, skuId)).getStockNum();
            log.info("剩余库存：{}", stockNum);
            if (stockNum <= 0) {
                return false;
            }
            String orderNo = UUID.randomUUID().toString().replace("-", "").toUpperCase();

            /** 减库存操作 **/
            if (stockService.decrease(skuId)) {
                OrderM order = new OrderM();
                order.setId(Long.valueOf(GenerateRandom.number(6)));
                order.setUserId(userId);
                order.setSkuId(skuId);
                order.setOrderNo(orderNo);
                order.setCreateTime(new Date());
                orderMapper.insert(order);
                return true;
            }
        } catch (Exception e) {
            log.error("下单失败: {}", e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        } finally {
            lock.unlock();
        }
        return false;
    }
}
