package Day4;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingLinkedListAndArrayDeque {
    void main() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("The Queue is : "+q);
        int val = q.poll();
        System.out.println("Deleting front value of queue : "+q);
        System.out.println("Removed value is : "+val);

        System.out.println("--------Queue using Array Dequeue-----------");
        Queue<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        dq.add(2);
        dq.add(3);
        System.out.println("The Arrya DeQueue is : "+dq);
        int val2 = dq.poll();
        System.out.println("Deleting front value of queue : "+dq);
        System.out.println("Removed value is : "+val2);


    }
}
