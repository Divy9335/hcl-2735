package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/v1/user")
public class EmployeeController {
    @Autowired
    private EmployeeService empService;
    @GetMapping("/")
    public String msg(){
        return "<h1>Welocme to HRMS</h1>";
    }

    @PostMapping("/addEmp")
    public String addEmp(@RequestBody Employee emp){
        return empService.addEmployee(emp);
    }

    @PostMapping("/login")
    public String login(@RequestParam("empid") long empid, @RequestParam("password") String password){
        if(empService.isLoggedIn(empid,password)){
            return "Employee is Logged in";
        }
        return "Employee not found";
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmp(){
        return empService.getAllEmp();
    }

    @GetMapping("/findById/{emp_id}")
    public Employee findById(@PathVariable long emp_id){
        return empService.findById(emp_id);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable long id){
       return empService.deleteById(id);
    }

    @PutMapping("/updateById/{id}")
    public String updateById(@PathVariable long id){
        return empService.updateById(id);
    }
}
