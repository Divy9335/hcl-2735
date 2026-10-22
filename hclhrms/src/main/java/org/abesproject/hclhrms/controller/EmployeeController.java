package org.abesproject.hclhrms.controller;

import org.abesproject.hclhrms.EmployeeService;
import org.abesproject.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService empSer;

    @GetMapping("/")
    public String welcomeMessage(){
        return "<h1> Welcome to HCL hrms app</h2>";
    }
    @GetMapping("/addemp")
    public String addNewEmp(){
        return empSer.addEmp();
    }
    @GetMapping("/getemp")
    public List<Employee> getEmp(){
        return empSer.getEmp();
    }

    @GetMapping("/getbyid")
    public Employee getEmpById(){
        return empSer.getEmpByid();
    }
    @GetMapping("/addinbulk")
    public String addEmpInBulk(){
        return empSer.addEmpInBulk();
    }
}
