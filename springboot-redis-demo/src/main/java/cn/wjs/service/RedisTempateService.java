package cn.wjs.service;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class RedisTempateService {

    @Resource
    private RedisTemplate<String, Object>  redisTemplate;

    @Resource
    private StringRedisTemplate redisTemplateString;

    /**
     *  获取指定前缀的一系列key
     *  使用scan命令代替keys, Redis是单线程处理，keys命令在KEY数量较多时，
     *  操作效率极低【时间复杂度为O(N)】，该命令一旦执行会严重阻塞线上其它命令的正常请求
     * @param keyPrefix
     * @return
     */
    public Set<String> keys(String keyPrefix) {
        redisTemplateString.opsForValue().set("aaa","bbb");
        Map map = new HashMap<>();
        map.put("aaa", "aaa");
        map.put("bbb","bbb");
        redisTemplate.opsForValue().set("map",map);
        String realKey = keyPrefix + "*";
        try {
            return redisTemplate.execute((RedisCallback<Set<String>>) connection -> {
                Set<String> binaryKeys = new HashSet<>();
                Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match(realKey).count(Integer.MAX_VALUE).build());
                while (cursor.hasNext()) {
                    binaryKeys.add(new String(cursor.next()));
                }
                return binaryKeys;
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

}

