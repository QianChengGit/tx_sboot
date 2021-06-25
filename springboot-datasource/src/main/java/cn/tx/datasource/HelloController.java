package cn.tx.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/hello")
    private String hello(){
        System.out.println(dataSource);
        return "hello springboot!";
    }

    @RequestMapping("/query")
    private List<Map<String, Object>> query(){
        List<Map<String, Object>> maps = jdbcTemplate
                .queryForList("select * from user01");
        return maps;
    }

    @RequestMapping("/findUser")
    private List<User> findUser(){
        return userMapper.findUser();
    }

}
