package com.example.face;

import com.example.face.config.serialize.SerializeUtil;
import com.example.face.sys.model.SysModule;
import com.example.face.utils.redis.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

@SpringBootTest
class FaceApplicationTests {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        redisTemplate.opsForValue().set("myKey","myKey");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }

    @Test
    public void saveObjectByRedis(){
        SysModule sys = new SysModule();
        sys.setPath("#");
        sys.setIcon("#");
        redisUtils.setObject("object",SerializeUtil.serialize(sys));
        SysModule s2 = (SysModule)SerializeUtil.unserialize(redisUtils.getObject("object"));
        System.out.println(s2.getPath());

    }
}
