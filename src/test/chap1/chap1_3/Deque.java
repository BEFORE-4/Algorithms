package test.chap1.chap1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> left;
    private Node<Item> right;
    private int size;
    class Node<T>{
        T item;
        Node<T> previous;
        Node<T> next;
    }
    Deque(){
        super();
    }
    boolean isEmpty(){
        return left == null;
    }
    int size(){
        return size;
    }
    void pushLeft(Item item){
        Node<Item> node = new Node<>();
        node.item = item;
        if (isEmpty()){
            right = node;
        }else{
            node.next = left;
            left.previous = node;
        }
        left = node;
        size++;
    }
    void pushRight(Item item){
        Node<Item> node = new Node<>();
        node.item = item;
        if (isEmpty()){
            left = node;
        }else{
            right.next = node;
            node.previous = right;
        }
        right = node;
        size++;
    }
    Item popLeft() throws NoSuchFieldException{
        if(isEmpty()){
            throw new NoSuchFieldException("no element!");
        }
        Item item = left.item;
        left = left.next;
        left.previous = null;
        size--;
        return item;
    }
    Item popRight() throws NoSuchFieldException{
        if (isEmpty())
            throw new NoSuchFieldException("no element!");
        Item item = right.item;
        right = right.previous;
        right.next = null;
        size--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    private class DequeIterator implements Iterator{
        private Node<Item> current = left;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
