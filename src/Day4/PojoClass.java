package Day4;

import java.util.ArrayList;
import java.util.List;

// USing sort operation on
public class PojoClass {
    static class Student {
        String name;
        int age;
        int roll;
        int marks;

        Student(String name, int age, int roll, int marks) {
            this.name = name;
            this.age = age;
            this.roll = roll;
            this.marks = marks;
        }


    }
    static void main() {
        List<Student> ls = new ArrayList<>();
        ls.add(new Student("divy",22,84,98));
        ls.add(new Student("prateek",22,144,97));
        ls.add(new Student("kamal",22,104,92));
        ls.add(new Student("mradul",22,125,95));
        ls.stream().forEach((student)->{
            System.out.println(student.name+" "+student.age+" "+student.roll);
        });
    }
}
