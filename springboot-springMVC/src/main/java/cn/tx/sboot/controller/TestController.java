package cn.tx.sboot.controller;

import cn.tx.sboot.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//不能返回视图,是@ResponseBody和@Controller的结合体
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "springMVC";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/testForward",produces = "application/json;charset=utf-8")
    public String testForward(){
        return "转发";
    }

    @RequestMapping("/selectPerson")
    public Person selectPerson(){
        Person person = new Person();
        person.setName("小华");
        person.setSex("男");
        person.setAge(18);
        return person;
    }
}
