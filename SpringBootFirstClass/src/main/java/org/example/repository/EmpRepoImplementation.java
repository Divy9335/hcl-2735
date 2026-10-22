package org.example.springbootfirstclass.repository;

import org.springframework.stereotype.Component;

@Component
public class EmpRepoImplementation implements EmpRepo{

    @Override
    public double squareRoot(double d) {
        double result = Math.sqrt(d);
        return result;
    }

    @Override
    public String empData() {
        return "";
    }

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int findGreatest(int a, int b) {
        return Math.max(a,b);
    }


}
