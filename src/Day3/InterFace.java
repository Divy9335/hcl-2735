package Day3;

public interface InterFace {
    static void walk(){
        System.out.println("Walking inside interface");
    }
    default void show(){
        System.out.println("Inside interface");
    }
    void run();
}
