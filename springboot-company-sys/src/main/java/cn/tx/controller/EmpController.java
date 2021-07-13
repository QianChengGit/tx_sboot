package cn.tx.controller;

import cn.tx.model.Emp;
import cn.tx.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("insert")
    public String insert(Emp emp){
        empService.insert(emp);
        return "success";
    }

    @GetMapping("getById")
    public Emp getById(int empId){
        Emp emp = empService.getById(empId);
        return emp;
    }

    @GetMapping("list")
    public List<Emp> list(){
        List<Emp> emps = empService.list();
        return emps;
    }

    @PostMapping("update")
    public String update(Emp emp){
        empService.update(emp);
        return "success";
    }

    @GetMapping("delete")
    public String delete(int empId){
        empService.delete(empId);
        return "success";
    }

}
