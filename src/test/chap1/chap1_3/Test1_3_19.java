package test.chap1.chap1_3;


public class Test1_3_19<T> {
    public static void main(String[] args) {
        Test1_3_19<String> q = new Test1_3_19<>();
        q.enqueue("a");
        q.delLast();
        q.enqueue("b");
        q.enqueue("c");
        q.delLast();
    }

    private Node<T> first;
    private Node<T> last;
    private int N;

    private class Node<N> {
        private N item;
        private Node<N> next;
    }

    private void enqueue(T item) {
        Node<T> node = new Node<>();
        node.item = item;
        if (first == null) {
            first = node;
        }
        if (last != null)
            last.next = node;
        last = node;
        N++;
    }

    private void delLast() {
        if (N == 1) {
            first = null;
            last = null;
        } else {
            Node<T> current = first;
            Node<T> last2 = first; //倒数第二个节点
            //循环遍历到最后一个节点，最后一个节点next为null
            while (current.next != null) {
                last2 = current;
                current = current.next;
            }
            last2.next = null;
            last = last2;
        }
        N--;
    }

}
