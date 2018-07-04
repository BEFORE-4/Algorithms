package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class GeneralizedQueue2<Item> {
    public static void main(String[] args) {
        GeneralizedQueue2<String> q = new GeneralizedQueue2<>();
        q.insert("a");
        q.insert("b");
        q.insert("c");
        q.insert("d");
        q.insert("e");
        StdOut.println(q.delete(5));
        StdOut.println(q.delete(2));
        StdOut.println(q.delete(3));
        StdOut.println(q.delete(1));
    }
    int N;  //链表尺寸
    Node<Item> first;   //第一个数据
    Node<Item> last;    //最后一个数据
    GeneralizedQueue2(){
        first = null;
        last = null;
        N = 0;
    }
    boolean isEmpty(){
        return N == 0;
    }
    void insert(Item x){
        Node<Item> node = new Node<>();
        node.item = x;
        if (isEmpty()){
            last = node;
            first = node;   //为空时，first需要赋值
        }else{
            last.next = node;
        }
        last = node;
        N++;
    }
    Item delete(int k){
        if (k > N || k <= 0)
            throw new NoSuchElementException("下标错误");
        N--;
        Item tmp;
        if (k == 1){    //第一个元素只需取first
            tmp = first.item;
            first = first.next;
            return tmp;
        }
        Node<Item> current = first;
        Node<Item> previous = current;
        while(--k > 0){
            previous = current;
            current = current.next;
        }
        previous.next = current.next;//前一个元素指向删除元素的后一个元素
        tmp = current.item;
        return tmp;
    }
}
