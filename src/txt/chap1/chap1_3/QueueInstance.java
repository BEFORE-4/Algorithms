package txt.chap1.chap1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class QueueInstance {
    public static int[] readInts(String name){
        In in = new In(name);
        Queue<Integer> q = new Queue<>();
        while (!in.isEmpty()){
            q.enqueue(in.readInt());
        }
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++){
            a[i] = q.dequeue();
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = readInts("txtFile/whitelist.txt");
        for (int i : a) {
            System.out.println(i);
        }
    }
}
