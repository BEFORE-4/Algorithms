package test.chap1.chap1_3;

import txt.chap1.chap1_3.Queue;
import txt.chap1.chap1_3.Stack;

public class Test1_3_6 {
    //将队列反向
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        Stack<String> stack = new Stack<>();
        while (!q.isEmpty()){
            stack.push(q.dequeue());
        }
        while (!stack.isEmpty()){
            q.enqueue(stack.pop());
        }
    }
}
