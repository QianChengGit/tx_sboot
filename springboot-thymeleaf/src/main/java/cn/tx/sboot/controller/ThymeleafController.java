package cn.tx.sboot.controller;

import cn.tx.sboot.model.Role;
import cn.tx.sboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ThymeleafController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("hello","嗨！前程");
        return "hello";
    }

    @GetMapping("hello1")
    public String hello1(Model model, HttpSession session){
        model.addAttribute("hello","嗨！前程");
        User user = new User("小华",21);
        user.setRole(new Role("教练"));
        model.addAttribute("user",user);
        model.addAttribute("now",new Date());
        session.setAttribute("user",user);
        return "hello";
    }

    @GetMapping("myurl")
    public String myurl(){
        return "myurl";
    }

    @ResponseBody
    @GetMapping("order/details")
    public String details(String itemName){
        System.out.println(itemName);
        return "ok";
    }
}
