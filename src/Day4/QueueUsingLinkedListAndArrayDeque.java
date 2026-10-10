package Day4;

import java.util.*;

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

        System.out.println();
        System.out.println("----------Implementing Stack-----------");
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println(st);
        System.out.println(st.pop());

    }

    class Solution {
        class Pair{
            long diff;
            long positiveDiff;
            int ind;
            Pair(long diff,long posDiff, int ind){
                this.diff = diff;
                this.positiveDiff = Math.abs(posDiff);
                this.ind = ind;
            }
        }

    }
}
