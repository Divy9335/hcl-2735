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

    @Override
    public String deleteEmpById(int id) {
        for(Employee emp : empList){
            if(emp.getEmp_id() == id){
                empList.remove(emp);
                return "Employee with emp_id "+emp.getEmp_id()+" is removed";
            }
        }
        return "No employee found with emp_id "+id;
    }

    @Override
    public String updateByEmpId(int id, Employee newEmp) {
        for(Employee emp : empList){
            if(emp.getEmp_id()==id){
                emp.setEmp_id(newEmp.getEmp_id());
                emp.setDesignation(newEmp.getDesignation());
                emp.setEmail(newEmp.getEmail());
                emp.setEmp_name(newEmp.getEmp_name());
                emp.setWork_stack(newEmp.getWork_stack());
                
                return "Employee with emp_id "+id+" is updated";
            }
        }
        return "No employee with eimp_id "+id+" is found";
    }
}
