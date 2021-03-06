package txt.chap1.chap1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Reverse {
    public static void main(String[] args) {
        In in = new In("txtFile/whitelist.txt");
        Stack<Integer> stack;
        stack = new Stack<>();
        while (!in.isEmpty())
            stack.push(in.readInt());
        for (int i : stack)
            StdOut.println(i);
    }
}
