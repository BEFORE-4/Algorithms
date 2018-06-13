package test.chap1.chap1_3;


import edu.princeton.cs.algs4.StdOut;

public class Test1_3_24<T> {
    private Node<T> first;
    private Node<T> last;
    private int N;

    public static void main(String[] args) {
        /*Test1_3_24<String> queue = new Test1_3_24<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        Node node = queue.getNode();
        queue.removeAfter(node);
        queue.enqueue("de");
        Node node1 = new Node();
        node1.item = "remove";
        queue.removeAfter(node1);   //1.3.24
        queue.enqueue("f");
        StdOut.println(queue.N);
        node1.item = "insertion";
        queue.insertAfter(node, node1); //1.3.25
        StdOut.println(queue.N);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("b");
        queue.enqueue("b");
        queue.remove(queue, "b");   //1.3.26
        queue.max(node1);*/

        //1.3.27
        Test1_3_24<Integer> q = new Test1_3_24<>();
        q.enqueue(1);
        q.enqueue(7);
        q.enqueue(3);
        StdOut.println(q.max(q.first));
        StdOut.println(q.maxRecursive(q.first));
    }

    /**
     * 随便写一个方法获取某个结点，可以删除该结点后的结点
     * @return 获取的结点
     */
    private Node<T> getNode(){
        Node<T> node;
        node = first.next;
        return node;
    }

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

    /**
     * Test1_3_24
     * 删除某个结点的后序结点
     * @param node 需要做操作的结点
     */
    private void removeAfter(Node<T> node){
        int index = 1;  //通过此值更改链表尺寸大小
        Node<T> current = first;
        while(current != null){
            if(current == node){
                current.next = null;
                N = index;  //链表尺寸变化
                last = current; //链表最后一个值变化
                return;
            }else{
                current = current.next;
                index++;
            }
        }
    }

    /**
     * Test1_3_25
     * 在原链表中某个节点后插入一个结点
     * @param node  原链表中的结点
     * @param insertion  插入的结点
     */
    private void insertAfter(Node<T> node, Node<T> insertion){
        int index = 1;
        Node<T> current = first;
        while (current != null){
            if (current == node){
                insertion.next = node.next;
                node.next = insertion;
                if (index == N)
                    last = insertion;   //最后一个结点，需要更改last的值
                N++;    //链表尺寸加1
                return;
            }else{
                current = current.next;
                index++;
            }
        }
    }

    /**
     * Test1_3_26
     * 删除链表中所有Item域为key的结点
     * @param q 链表
     * @param key  删除的域
     */
    private void remove(Test1_3_24<String> q, String key){
        Node before = q.first;
        for(Node x = first; x != null; x =x.next){
            if (x.item.equals(key)){
                if (key.equals(first.item)) //如果第一个结点被删去，first需要更改
                    first = first.next;
                N--;    //链表尺寸减1
                before.next = x.next;
                if (before.next == null)    //如果最后一个被删去，last需要更改
                    last = before;
            }else{
                before = x; //没有删去结点，则上个结点更改为现在这个结点，再循环
            }
        }
    }

    /**
     *  Test1_3_27
     *  返回链表中键最大的结点的值
     * @param node  首结点
     * @return  链表中的最大值
     */
    private int max(Node<Integer> node){
        int max = 0;
        for(;node != null; node = node.next){
            if (node.item > max){
                max = node.item;
            }
        }
        return max;
    }

    /**
     * Test1_3_28
     * 递归查找到最大值
     * @param node  第一个节点
     * @return  最大的值
     */
    private int maxRecursive(Node<Integer> node){
        int max = 0;
        if (node.next == null)
            max = node.item;
        else if(maxRecursive(node.next) > max)
            max = node.next.item;
        return max;
    }
}
class Node<T>{
    T item;
    Node<T> next;
}