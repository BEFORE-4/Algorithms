package test.chap1.chap1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    public static void main(String[] args) {
        int N = Integer.valueOf(args[0]);
        int M = Integer.valueOf(args[1]);
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.print(queue.dequeue() + "\t");   //报数为M的人出队列
        }
    }
}
