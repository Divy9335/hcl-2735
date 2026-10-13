package Day6;

public class GenricClasses{
    static void main() {
        Genric<Integer> sum = new Genric<>();
        int sumOfAAndB = sum.display(10,20);
        System.out.println(sumOfAAndB);
    }

}
