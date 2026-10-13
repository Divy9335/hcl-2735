package Day6;

public class Genric<T>{
    public static <T extends Number> int display(T a, T b){
        return a.intValue()+b.intValue();
    }
}
