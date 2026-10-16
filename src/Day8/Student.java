package Day8;

public class Student {
    private static final Student s1 = new Student();

    private Student(){
        System.out.println("Inside private constructor");
    }
    public static Student getInstance(){
        return s1;
    }
    private String name;
    private int rollNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }
}