package test.chap1.chap1_3;

import java.util.NoSuchElementException;

public class Test1_3_20<T> {
    public static void main(String[] args) {
        Test1_3_20<String> q = new Test1_3_20<>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.delete(2);
        q.delete(1);
    }
    private Node<T> first;
    private Node<T> last;
    private int N;

    private class Node<N>{
        private N item;
        private Node<N> next;
    }
    private void enqueue(T item){
        Node<T> node = new Node<>();
        node.item = item;
        if (N == 0){
            first = node;
        }else{
            last.next = node;
        }
        last = node;
        N++;
    }
    private void delete(int k){
        if (k > N || k <= 0)
            throw new NoSuchElementException("没有此元素");
        if (N == 1)
            last = null;
        N--;
        if(k == 1){
            first = first.next;
            return;
        }
        Node current = first;
        Node before = first;
        while (--k > 0){
            before = current;
            current = current.next;
        }
        before.next = current.next;
    }
}
