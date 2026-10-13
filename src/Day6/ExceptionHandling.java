package Day6;

import java.util.Scanner;

public class ExceptionHandling {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        try{
            int division = a/b;
            System.out.println(division);
        }catch (Exception e){
            System.out.println("The Exception is :"+e);
        }
    }
}
