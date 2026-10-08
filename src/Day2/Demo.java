package Day2;
import AnotherPackage.*;


public class Demo extends Demo2{

    class MyName{
        // private can be used only in same package only
        private MyName(){
            super();
        }
    }

    static void main() {
        System.out.println("Hi this is on branch main");
        Demo obj = new Demo();
        obj.newMethod();


    }
}
