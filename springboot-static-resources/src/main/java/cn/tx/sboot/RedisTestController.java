package cn.tx.sboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("test")
    public String test(){
        redisUtil.setCachObject("key","测试自定义Redis的starter");
        return (String) redisUtil.getCachObject("key");
    }
}
