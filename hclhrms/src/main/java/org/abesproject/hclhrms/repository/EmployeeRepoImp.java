package org.abesproject.hclhrms.repository;

import org.abesproject.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepoImp implements EmployeeRepo{


    @Autowired
    private Employee emp;
    List<Employee> empList = new ArrayList<>();

//    @Override
//    public Employee addEmplyee(String name, long id, String email, String designation, String stack) {
//        Employee emp =  new Employee(designation,email,id,name,stack);
//        empList.add(emp);
//        return emp;
//    }


    @Override
    public String addEmployee(Employee emp) {
        empList.add(emp);
        return "Added employee successfully";
    }

    @Override
    public List<Employee> getEmployee() {
        return empList;
    }

    @Override
    public Employee getEmpById(long id) {
        for(Employee emp : empList){
            System.out.println(emp.getEmp_id());
            if(emp.getEmp_id() == (int)id) return emp;
        }
        System.out.println("Employee not found");
        return null;
    }

    @Override
    public String addEmpBulk(List<Employee> ls) {
        empList.addAll(ls);
        return "Employee added in bulk";
    }
}
