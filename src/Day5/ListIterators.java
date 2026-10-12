package Day5;

import  java.util.*;
import java.util.ArrayList;
import java.util.List;
//class Student implements Comparable<Student>{
//    String name;
//    int id;
//    int roll;
//    int marks;
//    Student(String name, int id, int roll, int marks){
//        this.name = name;
//        this.id = id;
//        this.roll = roll;
//        this.marks = roll;
//    }
//    @Override
//    public int compareTo(Student o1) {
//        return Integer.compare(this.roll,o1.roll);
//    }
//}


class Student{
    String name;
    int id;
    int roll;
    int marks;
    Student(String name, int id, int roll, int marks){
        this.name = name;
        this.id = id;
        this.roll = roll;
        this.marks = roll;
    }
}

// using Comparator Implementations
//class sortByRoll implements Comparator<Student>{
//    @Override
//    public int compare(Student o1, Student o2) {
//        return Integer.compare(o1.roll,o2.roll);
//    }
//}

public class ListIterators {
    static void main() {
        List<Student> ls = new ArrayList<>();
        ls.add(new Student("divy",22,84,98));
        ls.add(new Student("prateek",22,144,97));
        ls.add(new Student("kamal",22,104,92));
        ls.add(new Student("mradul",22,125,95));
        // Using Comparable class --------
//        Collections.sort(ls,Student::compareTo);

        // Using Comparator interface --------
//        ls.sort(new sortByRoll());
//        Collections.sort(ls, new sortByRoll());

        //Using lamda function to implements comparator ----------

        // Using Lamda function to implement comparator ----------
        Collections.sort(ls,(s1,s2)->Integer.compare(s2.marks,s1.marks));

        // Iterator to iterate over the list items of Students --------
        Iterator<Student> s = ls.iterator();

        while(s.hasNext()){
            Student st = s.next();
            System.out.println(st.id+" "+st.name+" "+st.roll+" "+st.marks);
        }


    }

}

