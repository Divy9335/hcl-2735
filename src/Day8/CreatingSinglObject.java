package Day8;

public class CreatingSinglObject {
    static void main() {
        Student obj = Student.getInstance();
        System.out.println(obj);
        obj.setName("Divy Singh");

        Student obj2 = Student.getInstance();
        System.out.println(obj2);
        System.out.println(obj2.getName());

    }
}
