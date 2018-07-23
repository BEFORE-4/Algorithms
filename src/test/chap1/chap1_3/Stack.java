package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * chap 1_3_2
 * 仅有push和pop，其他方法去掉。pop的超过元素push数量会报NullPointerException异常
 */
public class Stack<Item> implements Iterable<Item>{
    private Node<Item> first;//栈顶元素


    private class Node<Item>{
        Item item;
        Node<Item> next;
    }
    public void push(Item item){
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    /**
     * 增加构造函数，复制栈
     */
    int size = 0;//尺寸
    Stack(){
        super();
    }
    //FILO特性，需要临时变量转换下顺序
    Stack(Stack<Item> q){
        Stack<Item> tmp = new Stack<>();
        for (Item obj : q) {
            tmp.push(obj);
        }
        for (Item obj : tmp) {
            push(obj);
        }
        this.size = q.size;
    }

    //返回栈中最近添加的元素
    public Item peek(){
        return first.item;
    }

    //破坏性连接两个栈对象 Test1_3_47
    public void catenation(Stack<Item> q){
        int size = q.size;
        for (int i = 0; i < size; i++) {
            push(q.pop());
        }
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Item item :
                this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /**
     * Test1_3_12
     * @param stack 字符串栈
     * @return  参数栈的副本
     */
    static Stack<String> copy(Stack<String> stack){
        Stack<String> tmp = new Stack<>();
        Stack<String> stacks = new Stack<>();
        for (String s :
                stack) {
            tmp.push(s);
        }
        for (String s :
                tmp) {
            stacks.push(s);
        }
        return stacks;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }
    class ListIterator<T> implements Iterator{
        private Node<Item> current;

        ListIterator(Node<Item> item){
            current = item;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new NoSuchElementException("no remove");
        }
    }



    public static void main(String[] args) {
       /* //chap 1_3_2
        //it was - the best - of times - - - it was - the - -
        //输出结果为
        //was best times of the was the it
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else{
                StdOut.println(stack.pop() + " ");
            }
        }*/
      /*
       //chap 1_3_12
       Stack<String> stack = new Stack<>();
       stack.push("c");
       stack.push("b");
       stack.push("a");
       Stack<String> result = copy(stack);
        for (String s :
                result) {
            System.out.println(s);
        }
        */
    }
}
