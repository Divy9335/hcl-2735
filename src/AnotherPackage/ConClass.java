package AnotherPackage;
// The access modifier of Constructor outside the package is same as the access modifier of its class.
// Private modifier can be made inside the same package but outside it should be same as its parent class access modifier
public class ConClass {
    public ConClass(){
        System.out.println("This is Default constructor");
    }
//    public ConClass(int a){
//        System.out.println("the number is :"+a);
//        this(1,2);
//    }
//    public ConClass(int a, int b){
//        System.out.println("sum of a and b is :"+(a+b));
//    }
//
    public void newMethod(){
        System.out.println("from new method");
    }

}
