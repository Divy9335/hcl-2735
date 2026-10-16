package org.example;

import org.example.StudentPackage.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

//    @Bean
//    @Primary
//    public Student Student(){
//        return new Student();
//    }

}
