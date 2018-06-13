package test.chap1.chap1_3;

import java.util.NoSuchElementException;

public class Test1_3_29<T> {
    Node<T> last;
    int N;
    //入队操作
    void enqueue(T item){
        Node<T> node = new Node<>();
        node.item = item;
        if (N == 0){
            last = node;        //最后一个节点
            last.next = node;   //最后一个节点的next指向该节点，即first
        }else {
            node.next = last.next;  //新增节点的next指向last的next,即first
            last.next = node;   //之前last的next不再指向first,指向node
            last = node;    //last变为增加的这个节点
        }
        N++;
    }
    //出队操作
    T dequeue(){
        if (N <= 0)
            throw new NoSuchElementException("there is no node!");
        T item;
        Node<T> first = last.next;
        if (N == 1){
            last = null;    //只有一个元素，出队后last为null
        }else{
            last.next = first.next;  //last.next更改为first的下一个节点
            first.next = null;  //first的next赋值null，避免游离
        }
        item = first.item;
        N--;
        return item;
    }
    public static void main(String[] args) {
        Test1_3_29<String> queue = new Test1_3_29<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("d");
    }
}

