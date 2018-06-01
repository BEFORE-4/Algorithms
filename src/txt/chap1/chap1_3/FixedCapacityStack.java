package txt.chap1.chap1_3;

import java.util.Iterator;

/**
 * 泛型
 * @param <Item>
 */
public class FixedCapacityStack<Item> implements  Iterable<Item>{
    private Item[] cap;//栈
    private int N;  //栈尺寸
    public FixedCapacityStack(int cap){
        this.cap = (Item[])new Object[cap];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        //调整数组大小
        if (N == cap.length)
            resize( 2 * cap.length);
        cap[N++] = item;
    }
    public Item pop(){
        Item item = cap[--N];
        cap[N] = null;
        if (N > 0 && N == cap.length / 4){
            resize(cap.length / 2);
        }
        return item;
    }
    private void resize(int max){
        Item[] temp = (Item[])new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = cap[i];
        }
        cap = temp;
    }
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return cap[--i];
        }

        @Override
        public void remove() {

        }
    }

}
