package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * 双向队列实现了两个栈。只实现了push pop size isEmpty 等基本方法
 *  测试方法在最下面
 */
public class Test1_3_48<Item> {
    private Node<Item> left, right; //两个栈
    private int leftSize, rightSize;//两个栈的size
    class Node<T>{
        T item;
        Node<T> previous;
        Node<T> next;
    }
    int leftSize(){
        return leftSize;
    }
    int rightSize(){
        return rightSize;
    }
    void pushLeft(Item item){
        Node<Item> node = new Node<>();
        node.item = item;
        if (isEmptyLeft()){
            left = node;
        }else{
            node.next = left;
            left.previous = node;
            left = node;
        }
        leftSize++;
    }
    void pushRight(Item item){
        Node<Item> node = new Node<>();
        node.item = item;
        if (isEmptyRight()){
            right = node;
        }else {
            right.next = node;
            node.previous = right;
            right = node;
        }
        rightSize++;
    }
    boolean isEmptyLeft(){
        return leftSize == 0;
    }
    boolean isEmptyRight(){
        return rightSize == 0;
    }
    Item popLeft() throws NoSuchFieldException{
        if (isEmptyLeft())
            throw new NoSuchFieldException("left no elements!");
        Node<Item> node = left;
        left = node.next;
        leftSize--;
        return node.item;
    }
    Item popRight() throws NoSuchFieldException{
        if (isEmptyRight())
            throw new NoSuchFieldException("left no elements!");
        Node<Item> node = right;
        right = node.previous;
        rightSize--;
        return node.item;
    }
    public static void main(String[] args) throws NoSuchFieldException{
        Test1_3_48<String> q = new Test1_3_48<>();
        q.pushLeft("a");
        q.pushLeft("b");
        q.pushLeft("c");
        q.pushLeft("d");
        System.out.println(q.leftSize());
        q.pushRight("z");
        q.pushRight("y");
        q.pushRight("x");
        System.out.println(q.rightSize());
        System.out.println(q.popLeft());
        System.out.println(q.popLeft());
        System.out.println(q.popLeft());
        System.out.println(q.popLeft());
        StdOut.println(q.popRight());
        StdOut.println(q.popRight());
        StdOut.println(q.popRight());
    }
}
