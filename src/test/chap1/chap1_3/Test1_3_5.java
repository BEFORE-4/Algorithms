package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;
import txt.chap1.chap1_3.Stack;

public class Test1_3_5 {
    //输出N的二进制
    public static void main(String[] args) {
        int N = 50;
        Stack<Integer> stack = new Stack<>();
        while (N > 0){
            stack.push(N % 2);
            N = N / 2;
        }
        for (Integer d : stack){
            StdOut.print(d);
        }
        StdOut.println();
    }
}
