package Day6;

import java.util.Scanner;
/* To make your own exception then extend the super class Exception and then create a constructor of that with some paramaters you want
to show in your exception generally take string inside constructor and pass that message to its super class that means exception

Now inside try block when exception occurs then simply throw you own exception by using "throw" key-word and after throw keyWord
use the object of you custom exception class with the message in its constructor to show that message in the console or terminal window.



*/
class myExcetpion extends Exception{
    myExcetpion(String message){
        super(message);
    }
}


public class UserDefinedException {

    static void main() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        try{
            if(b==0) throw new myExcetpion("Zero se mat divide karo");
            int ans = a/b;
        }catch (myExcetpion e){
            System.out.println(e);
        }
    }
}
