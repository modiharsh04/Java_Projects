import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HackerRankQueueWithTwoStack {
    
    static Stack<Long> enqueue = new Stack<>();
    static Stack<Long> dequeue = new Stack<>();
    static Scanner sc;
    
    static void doWork(int command){
        switch(command){
            case 1:
            enQ(sc.nextLong());
            break;
            case 2:
            deQ();
            break;
            case 3:
            printElem();
            break;
        }
    }
    
    static void printElem(){
        if(dequeue.size() == 0) while (!enqueue.isEmpty()) dequeue.push(enqueue.pop());
        System.out.println(dequeue.peek());
    }
    
    static void enQ(long val){
        enqueue.push(val);
    }
    
    static void deQ(){
        if(dequeue.size() == 0) while (!enqueue.isEmpty()) dequeue.push(enqueue.pop());
        dequeue.pop();
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q>0){
            doWork(sc.nextInt());
            --q;
        }
    }
}