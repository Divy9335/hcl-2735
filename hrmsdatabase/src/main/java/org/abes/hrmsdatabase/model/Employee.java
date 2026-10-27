package org.abes.hrmsdatabase.model;

import jakarta.persistence.*;

@Entity
@Table
public class Employee {

    @Id
    private long empid;
    private String name;

    @Column(name = "techStack")
    private String techStack;
    private String designation;
    private String email;
    private String password;

    public Employee(){

    }

    public Employee(long empid, String name, String techStack, String designation, String email, String password) {
        this.empid = empid;
        this.name = name;
        this.techStack = techStack;
        this.designation = designation;
        this.email = email;
        this.password = password;
    }

    public long getEmpid() {
        return empid;
    }

    public void setEmpid(long empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                ", techStack='" + techStack + '\'' +
                ", designation='" + designation + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
