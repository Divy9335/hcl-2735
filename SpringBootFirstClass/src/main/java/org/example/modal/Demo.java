package org.example.springbootfirstclass.modal;

import org.example.springbootfirstclass.repository.EmpRepoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo {
    @Autowired
    private EmpRepoImplementation empImp;

    public int add(int a, int b){
        return empImp.add(a,b);
    }

    public double sqrt(double d){
        return empImp.squareRoot(d);
    }

    public int findGreaterNumber(int a, int b){
        return empImp.findGreatest(a,b);
    }
}
