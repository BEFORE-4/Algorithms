package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * chap 1_3_2
 * 仅有push和pop，其他方法去掉。pop的超过元素push数量会报NullPointerException异常
 */
public class Stack<Item> {
    private Node first;//栈顶元素
    private class Node{
        Item item;
        Node next;
    }
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        return item;
    }

    //it was - the best - of times - - - it was - the - -
    //输出结果为
    //was best times of the was the it
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else{
                StdOut.println(stack.pop() + " ");
            }
        }
    }
}
