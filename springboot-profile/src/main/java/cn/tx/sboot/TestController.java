package cn.tx.sboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@EnableConfigurationProperties(Config.class)
public class TestController {

    @Autowired
    private Config config;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("访问config界面！");
        System.out.println(config.toString());
        return config.toString();
    }
}
