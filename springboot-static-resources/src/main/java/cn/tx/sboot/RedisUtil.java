package cn.tx.sboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

//Redis的工具类
@Component
public class RedisUtil<T> {

    @Autowired
    @Qualifier("redisTemplate")
    public RedisTemplate redisTemplate;

    public RedisTemplate getRedisTemplate(){
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public <T> ValueOperations<String,T> setCachObject(String key,T value){
        ValueOperations<String,T> operations = redisTemplate.opsForValue();
        operations.set(key, value);
        return operations;
    }

    public <T> ValueOperations<String,T> setCachObject(String key,T value,long time){
        ValueOperations<String,T> operations = redisTemplate.opsForValue();
        operations.set(key, value, time, TimeUnit.SECONDS);
        return operations;
    }

    public <T> T getCachObject(String key){
        ValueOperations<String,T> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }
}
