package txt.chap1.chap1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
    private Node first; //第一个节点
    private Node last;  //最后一个节点
    private int N;  //数量


    private class Node{
         Item item;
         Node next;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        private Node node = first;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return node.next.item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        Queue<String> s = new Queue<>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.enqueue(item);
            else if (!s.isEmpty()){
                StdOut.print(s.dequeue() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
