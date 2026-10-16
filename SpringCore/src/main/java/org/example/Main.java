package org.example;


import org.example.School.School;
import org.example.StudentPackage.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
        School stXaviers = app.getBean(School.class);
        stXaviers.setS1("Divy Singh");
        stXaviers.getName();
    }
}