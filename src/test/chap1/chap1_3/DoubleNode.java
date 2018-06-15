package test.chap1.chap1_3;

import java.util.NoSuchElementException;

public class DoubleNode<T> {
    public static void main(String[] args) {
        DoubleNode<String> queue = new DoubleNode<>();
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        queue.insertHead(a);
        queue.insertTail(c);
        queue.insertHead(b);
        queue.insertTail(d);

    }
    private int N;
    private Node<T> first;
    private Node<T> last;

    void insertHead(Node<T> node){
        if (isEmpty()){
            last = node;
        }else{
            node.next = first;
            first.previous = node;
        }
        first = node;
        N++;
    }
    void insertTail(Node<T> node){
        if(isEmpty()){
            first = node;
        }else{
            last.next = node;
            node.previous = last;
        }
        last = node;
        N++;
    }
    void delHead(){
        if(isEmpty())
            throw new NoSuchElementException("is Empty!");
        first = first.next;
        if(first != null)
            first.previous = null;
        N--;
        if (N == 0)
            last = first;
    }
    void delTail(){
        if(isEmpty())
            throw new NoSuchElementException("is Empty!");
        last = last.previous;
        if(last != null)
            last.next = null;
        N--;
        if (N == 0)
            first = last;
    }
    void insertHead(Node<T> node, Node<T> existNode){
        if (first == existNode)
            insertHead(node);
        else{
            node.previous = existNode.previous;
            node.next = existNode;
            existNode.previous.next = node;
            existNode.previous = node;
        }
        N++;
    }
    void insertTail(Node<T> node, Node<T> existNode){
        if(last == existNode)
            insertTail(node);
        else{
            node.previous = existNode;
            node.next = existNode.next;
            existNode.next.previous = node;
            existNode.next = node;
        }
        N++;
    }
    void delNode(Node<T> node){
        if (isEmpty())
            throw new NoSuchElementException("is Empty!");
        Node tmp = first;
        int index = 1;
        while(tmp != null){
            if (node == tmp){
                if (index == 1)
                    delHead();
                else if (index == N)
                    delTail();
                else {
                    tmp.previous.next = tmp.next;
                    tmp.next = tmp.previous;
                }
                N--;
                break;
            }
            tmp = tmp.next;
            index++;
        }
    }
    boolean isEmpty(){
        return N == 0;
    }
    static class Node<T>{
        Node(T item){
            this.item = item;
        }
        T item;
        Node<T> previous;
        Node<T> next;
    }
}

