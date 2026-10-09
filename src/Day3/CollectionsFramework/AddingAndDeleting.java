package Day3.CollectionsFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingAndDeleting {
    static void main(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> ls = new ArrayList<>(n);
        System.out.println("<-----------Inserting data into list --------->");
        for(int i= 0;i<n;i++){
            ls.add(sc.nextInt());
        }
        System.out.println("Printing Data after insertion -- " + ls);

        ls.remove(1);
        System.out.println("Deleting a data and then printing the list -- "+ls);

        ls.set(1,24);
        System.out.println("Setting data at index one -- "+ls);

        System.out.println("Checking is list empty or not -- "+ls.isEmpty());

        System.out.println("Checking that data is inside the list or not - "+ls.contains(10));


    }
}
