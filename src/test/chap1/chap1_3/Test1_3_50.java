package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * 在Stack类中增加异常后，此时迭代中修改会有异常
 */
public class Test1_3_50 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        StdOut.println("在迭代器中修改，会产生异常");
        for (String str : stack) {
            stack.push("c");
            StdOut.println("产生异常");
        }
    }
}
