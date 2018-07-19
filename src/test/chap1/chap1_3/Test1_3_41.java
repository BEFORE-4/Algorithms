package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 复制队列
 */
public class Test1_3_41 {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        Queue<String> q = new Queue<>();
        q.enqueue(a);   //两个都会入列
        q.enqueue(b);   //两个都会入列
        Queue<String> r = new Queue<>(q);
        q.enqueue(c);   //构造函数之后，只有q会入列
        r.enqueue("d"); //只有r会入列
        r.enqueue("e"); //只有r会入列
        try {
            q.dequeue();    //只有q会出列
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }
        System.out.println("q的数量是： " + q.size());
        for (String str :
                q) {
            StdOut.print(str + "\t");
        }
        StdOut.println();
        System.out.println("r的数量是： " + q.size());
        for (String str :
                r) {
            StdOut.print(str + "\t");
        }
    }
}
class Queue<Item> implements Iterable<Item>{
    private Node<Item> first;
    private Node<Item> last;
    private int size;
    class Node<T>{
        T item;
        Node<T> next;
    }
    int size(){
        return size;
    }
    boolean isEmpty(){
        return size == 0;
    }
    Queue(){
        super();
    }
    Queue(Queue<Item> q){
        for (Item obj : q) {
            enqueue(obj);
        }
        this.size = q.size();
    }
    void enqueue(Item item){
        Node<Item> node = new Node<>();
        node.item = item;
        if (isEmpty()){
            first = node;
        }else{
            last.next = node;
        }
        last = node;
        size++;
    }
    Item dequeue() throws NoSuchFieldException{
        if (isEmpty())
            throw new NoSuchFieldException("no element");
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public Iterator<Item> iterator(){
        return new QueueIterator();
    }
    private class QueueIterator implements Iterator<Item>{
        private Node<Item> current = first;
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
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

