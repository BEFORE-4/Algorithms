package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;

public class Test1_3_30<T> {

    public static void main(String[] args) {
        Test1_3_30<String> queue = new Test1_3_30<>();
        for (int i = 0; i < 220000000; i++){
            String a = "a";
            queue.enqueue(a);
        }
        Node<String> first = queue.first;
        long start = System.currentTimeMillis();
        StdOut.println(start);
        Node<String> newFirst = queue.reverse(first);
        long end = System.currentTimeMillis();
        StdOut.println(end);
        StdOut.println(end - start);
        start = System.currentTimeMillis();
        StdOut.println(start);
        Node<String> newFirst1 = queue.reverse1(first);
        end = System.currentTimeMillis();
        StdOut.println(end);
        StdOut.println(end - start);
    }

    /**
     * 反转链表
     * @param first 链表的首结点
     * @return  反转后链表的首结点，即原链表最后一个结点
     */
    private Node<T> reverse(Node<T> first){
        Node<T> reverse = null;
        while (first != null){
            Node<T> second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    /**
     * 递归反转
     * @param first 链表的首结点
     * @return 反转后链表的首结点，即原链表最后一个结点
     */
    private Node<T> reverse1(Node<T> first){
        if (first == null)
            return null;
        if(first.next == null)
            return first;
        Node<T> second = first.next;
        Node<T> reverse = reverse1(second);
        second.next = first;
        first.next = null;
        return reverse;
    }
    private Node<T> first;
    private Node<T> last;
    private int N;
    /**
     * 添加一个结点给链表
     * @param item 结点
     */
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
