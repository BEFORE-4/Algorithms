package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;

public class Test1_3_7 {
    //在该包下的Stack中添加
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        StdOut.println(stack.peek());   //输出c
        StdOut.println(stack.pop());    //没有弹出，仍然输出c
    }
}
