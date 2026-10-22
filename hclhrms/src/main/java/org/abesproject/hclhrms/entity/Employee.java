package org.abesproject.hclhrms.entity;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private long emp_id;
    private String emp_name;
    private String designation;
    private String work_stack;
    private String email;

    public Employee() {
    }

    public Employee(String designation, String email, long emp_id, String emp_name, String work_stack) {
        this.designation = designation;
        this.email = email;
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.work_stack = work_stack;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getWork_stack() {
        return work_stack;
    }

    public void setWork_stack(String work_stack) {
        this.work_stack = work_stack;
    }
}
