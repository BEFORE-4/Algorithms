package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;

public class Test1_3_21<T> {
    public static void main(String[] args) {
        Test1_3_21<String> queue = new Test1_3_21<>();
        queue.enqueue("a");
        queue.enqueue("b");
        StdOut.println(queue.find(queue, "a"));
        StdOut.println(queue.find(queue, "ae"));
        StdOut.println(queue.find(queue, "b"));
    }

    boolean find(Test1_3_21<String> queue, String key){
        Node<String> node = (Node<String>)queue.first;
        while (node != null){
            if (node.item.equals(key)){
                return true;
            }
            node = node.next;
        }
        return false;
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
            last = node;
        }else {
            last.next = node;
            last = node;
        }
        N++;
    }
}
