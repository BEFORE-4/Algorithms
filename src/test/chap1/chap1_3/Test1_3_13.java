package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;
import txt.chap1.chap1_3.Queue;

public class Test1_3_13 {
    //只有第一种可以
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            StdOut.print(queue.dequeue() + "\t");
        }
    }
}
