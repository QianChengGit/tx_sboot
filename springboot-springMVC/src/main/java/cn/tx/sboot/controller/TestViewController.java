package cn.tx.sboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//可以返回视图
public class TestViewController {

    @RequestMapping("/test1")
    public String test1(){
        return "index";
    }

    @RequestMapping("/hello1")
    public String hello1(){
        return "forward:testForward";
    }

    @RequestMapping("/hello2")
    public String hello2(){
        return "redirect:testForward";
    }

    @RequestMapping(value = "/test2",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String test2(){
        return "测试";
    }

}
