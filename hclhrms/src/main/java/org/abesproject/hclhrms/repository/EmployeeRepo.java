package org.abesproject.hclhrms.repository;

import org.abesproject.hclhrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo {
//    Employee addEmplyee(String name, long id, String email, String designation, String stack);
    String addEmployee(Employee emp);
    List<Employee> getEmployee();
    Employee getEmpById(long id);
    String addEmpBulk(List<Employee> ls);

    String deleteEmpById(int id);
    String updateByEmpId(int id, Employee newEmp);

}
