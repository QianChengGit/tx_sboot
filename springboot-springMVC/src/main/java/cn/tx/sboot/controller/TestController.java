package cn.tx.sboot.controller;


import cn.tx.sboot.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "springMVC";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
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
