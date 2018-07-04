package test.chap1.chap1_3;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Steque<T> implements Iterable {
    public static void main(String[] args) {
        Steque<String> s = new Steque<>();
        s.enqueue("a");
        s.enqueue("b");
    }
    private Node<T> first;
    private Node<T> last;
    class Node<E>{
        E item;
        Node<E> next;
    }
    T pop(){
        if (first == null)
            throw new NoSuchElementException("empty!");
        Node<T> node = first;
        first = first.next;
        if (first == null)
            last = null;
        return node.item;
    }
    void push(T item){
        Node<T> node = new Node<>();
        node.item = item;
        if(first == null){
            first = node;
            last = node;
        }else{
            node.next = first;
            first = node;
        }
    }
    void enqueue(T item){
        Node<T> node = new Node<>();
        node.item = item;
        if (first == null){
            first = node;
        }else{
            last.next = node;
        }
        last = node;
    }

    @Override
    public Iterator iterator() {
        return new ListIt();
    }
    class ListIt implements Iterator{
        private Node<T> current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            current = current.next;
            return current;
        }
    }
}
