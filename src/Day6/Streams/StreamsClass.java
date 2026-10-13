package Day6.Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsClass {
    static class Person{
        String name;
        String gender;
        Person(String name, String gender){
            this.name = name;
            this.gender = gender;
        }
    }
    static void main() {
//        List<Integer> ls = new ArrayList<>();
//        ls.add(1);
//        ls.add(2);
//        ls.add(3);
//        ls.add(4);
//
//        ls.stream().filter((num)->num%2==0).forEach(System.out::println);
//        List<Integer> newLs = ls.stream().filter((num)->num%2==0).toList();
//        System.out.println(newLs);



        List<Person> pers = new ArrayList<>();

        pers.add(new Person("Divy","male"));
        pers.add(new Person("Kamal","male"));
        pers.add(new Person("Shruti","female"));
        pers.add(new Person("Kamal","male"));
        pers.add(new Person("Reena","female"));



        pers.stream().map((person)->{
            if(person.gender=="male") return "Mr. "+person.name;
            return "Mrs. "+person.name;
        }).forEach(System.out::println);
    }
}
