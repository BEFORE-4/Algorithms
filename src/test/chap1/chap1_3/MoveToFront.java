package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 前移编码
 * @param <Item> 数据泛型
 */
public class MoveToFront<Item> implements Iterable<Item>{
    public static void main(String[] args) {
        MoveToFront<String> qu = new MoveToFront<>();
        String a = "asdfasdfasdfas23432fvdszfgdf";
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            qu.read(String.valueOf(chars[i]));
        }
        for (String str:
             qu) {
            StdOut.println(str);
        }
        StdOut.println(qu.size);
    }
    Node<Item> first;
    int size;
    boolean isEmpty(){
        return size == 0;
    }
    void read(Item item){
        deleteItem(item);
        Node<Item> newNode = new Node<>();
        newNode.item = item;
        newNode.next = first;
        first = newNode;
        size++;
    }
    void deleteItem(Item item){
        if (isEmpty())
            return;
        Node<Item> current = first;
        Node<Item> previous = current;
        if (first.item.equals(item)){
            first = first.next;
            return;
        }
        while (current != null){
            if (item.equals(current.item)){
                previous.next = current.next;
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }
    @Override
    public Iterator<Item> iterator() {
        return new MoveToFrontIterator(first);
    }
    class MoveToFrontIterator implements Iterator{
        private Node<Item> current;
        MoveToFrontIterator(Node<Item> first){
            this.current = first;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Item tmp = current.item;
            current = current.next;
            return tmp;
        }
    }
}
