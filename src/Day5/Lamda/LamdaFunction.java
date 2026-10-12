package Day5.Lamda;

public class LamdaFunction implements Calculator{

     Calculator add = (a, b)-> System.out.println(a+b);
     Calculator mul = (a,b)-> System.out.println(a*b);
     Calculator div = (a,b)-> System.out.println(a/b);

    static void main() {
        LamdaFunction operation = new LamdaFunction();
        operation.add.mathmeticalOperation(2,3);
        operation.mul.mathmeticalOperation(4,5);
        operation.div.mathmeticalOperation(6,2);

    }

    @Override
    public void mathmeticalOperation(int a, int b) {

    }
}
