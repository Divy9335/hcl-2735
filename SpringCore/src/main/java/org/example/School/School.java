package org.example.School;

import org.example.StudentPackage.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class School {
    @Autowired
    Student s1;
    public void getName(){
        System.out.println(s1.getName());
    }
    public void setS1(String name) {
        s1.setName(name);
    }
}
