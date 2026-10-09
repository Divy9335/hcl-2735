package Day2;

// static method can't be overridden this is called as method Hiding
//public class MethodHidingChild extends MethodHiding{
//    void show(){
//        System.out.println("From child");
//    }
//    public static void main() {

import Day3.AbstractClass;

////        MethodHiding m = new MethodHidingChild();
////        MethodHiding m2 = new MethodHiding();
////        m2.show();
////        m.show();
//    }
//}


public class MethodHidingChild {
    static void main() {
        AbstractClass a = new AbstractClass();
        a.run();
        a.show();
    }
}
