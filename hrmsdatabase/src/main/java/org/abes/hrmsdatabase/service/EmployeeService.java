package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo empRepo;

    public String addEmployee(Employee emp){
        empRepo.save(emp);
        return "Employee added successfully";
    }

    public List<Employee> getAllEmp(){
        List<Employee> data = empRepo.findAll();
        data.forEach(System.out::println);
        return data;
    }

    public Employee findById(long empId){
        System.out.println("Employee id "+empId);
        return empRepo.findById(empId).orElse(null);
    }


    public String deleteById(long id){
        Employee tempEmp = findById(id);
        if(tempEmp==null) return "Employee is not present";
        empRepo.deleteById(id);
        return "Employee Deleted from the dataBase "+id;
    }
    public String updateById(long id){
        Employee tempEmp = findById(id);
        if(tempEmp==null) return "Employee is not present";
        tempEmp.setDesignation("NewBie");
        tempEmp.setName("Aman singh");
        tempEmp.setTechStack("Java fullStack");
        empRepo.save(tempEmp);
        return "Employee Updated successfully : "+id;
    }
}
