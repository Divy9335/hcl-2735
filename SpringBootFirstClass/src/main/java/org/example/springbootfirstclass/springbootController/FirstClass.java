package org.example.springbootfirstclass.springbootController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstClass {

    @GetMapping("/")
    public String show(){
        return "<h2> Weclome to HRMS </h2>";
    }
}
