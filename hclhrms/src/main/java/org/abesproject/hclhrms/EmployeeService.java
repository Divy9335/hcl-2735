package org.abesproject.hclhrms;

import org.abesproject.hclhrms.entity.Employee;
import org.abesproject.hclhrms.repository.EmployeeRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepoImp emp;

    public String addEmp(){
        return emp.addEmployee(new Employee("senior engineer","abc@gmail.com",2345,"Kamal pratap","frontend"));
    }

    public List<Employee> getEmp(){
        return emp.getEmployee();
    }

    public Employee getEmpByid(){
        return emp.getEmpById(2345);
    }

    public String addEmpInBulk(){
        List<Employee> temList = new ArrayList<>();
        temList.add(new Employee("senior engineer","abc@gmail.com",2300,"Divy Singh","Backend"));
        temList.add(new Employee("Associate engineer","abc@gmail.com",2400,"Teotia Singh","Associate"));
        temList.add(new Employee("fullstack engineer","Divy@gmail.com",1,"Mridul yash","Backend"));
        return emp.addEmpBulk(temList);
    }
}
