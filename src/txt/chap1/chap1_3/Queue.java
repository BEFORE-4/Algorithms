package txt.chap1.chap1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>{
    private Node<Item> first; //第一个节点
    private Node<Item> last;  //最后一个节点
    private int N;  //数量


    private class Node<T>{
         private T item;
         private Node<T> next;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node<>();
        last.item = item;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }
    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }
    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
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
