package cn.wjs;


import cn.wjs.service.RedisTempateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private RedisTempateService redisTempateService;

    @Test
    public void test() {
//        long startTime = System.currentTimeMillis();
//        String matchKey = "*";
//        Set<String> keys = new HashSet();
//        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
//        RedisConnection redisConnection = connectionFactory.getConnection();
//        Cursor<byte[]> scan = null;
//        if (redisConnection instanceof JedisClusterConnection) {
//            RedisClusterConnection clusterConnection = connectionFactory.getClusterConnection();
//            Iterable<RedisClusterNode> redisClusterNodes = clusterConnection.clusterGetNodes();
//            Iterator<RedisClusterNode> iterator = redisClusterNodes.iterator();
//            while (iterator.hasNext()) {
//                RedisClusterNode next = iterator.next();
//                scan = clusterConnection.scan(next, ScanOptions.scanOptions().match(matchKey).count(Integer.MAX_VALUE).build());
//                while (scan.hasNext()) {
//                    keys.add(new String(scan.next()));
//                }
//                try {
//                    if (scan != null) {
//                        scan.close();
//                    }
//                } catch (IOException e) {
//                    log.error("scan遍历key关闭游标异常", e);
//                }
//            }
//            System.out.println(keys);
//        }
//        if (redisConnection instanceof JedisConnection) {
//            scan = redisConnection.scan(ScanOptions.scanOptions().match(matchKey).count(Integer.MAX_VALUE).build());
//            while (scan.hasNext()) {
//                //找到一次就添加一次
//                keys.add(new String(scan.next()));
//            }
//            try {
//                if (scan != null) {
//                    scan.close();
//                }
//            } catch (IOException e) {
//                log.error("scan遍历key关闭游标异常", e);
//            }
//            System.out.println(keys);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime-startTime);

        Set<String> set = redisTempateService.keys("ddd");
        System.out.println(set.size());
    }

}

