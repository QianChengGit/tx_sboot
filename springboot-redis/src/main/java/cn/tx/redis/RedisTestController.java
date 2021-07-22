package cn.tx.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("test")
    public String test(){
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("txkey","txvalue");
        return "ok";
    }
}
