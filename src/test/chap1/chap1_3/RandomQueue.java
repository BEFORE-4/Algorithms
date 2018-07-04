package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue<Item> implements Iterable<Item>{
    Item[] q;
    int N;
    int first;
    int last;
    RandomQueue(){
        N = 0;
        q = (Item[]) new Object[2];
        first = 0;
        last = 0;
    }
    boolean isEmpty(){
        return N == 0;
    }
    void enqueue(Item item){
        if (N == q.length)
            resize(q.length * 2);
        if (!isEmpty())     //非空数组加入时，last需要加1
            last++;
        q[last] = item;
        N++;
    }

    private void resize(int capacity){
        Item[] result = (Item[]) new Object[capacity];
        System.arraycopy(q, 0, result, 0, N);//数组复制，复制N个
        /*for (int i = 0; i < N; i++) {
            result[i] = q[i];
        }*/
        q = result;
    }
    /**
     * 删除并随机返回一个元素（取样不放回）
     * @return 随机返回的元素
     */
    Item dequeue(){
        int index = StdRandom.uniform(N);
        Item tmp = q[index];
        q[index] = q[last];
        N--;
        last--;
        if (N == q.length / 4)
            resize(q.length / 2);
        return tmp;
    }

    /**
     * 随机返回一个元素但不删除（取样且放回）
     * @return  随机返回的元素
     */
    Item sample(){
        int index = StdRandom.uniform(N);
        return q[index];
    }
    @Override
    public Iterator<Item> iterator() {
        return new randomIterator(q, N);
    }
    class randomIterator implements Iterator<Item>{
        private int index = 0;
        private int num;
        private Item[] items;
        randomIterator(Item[] item, int N){
            this.items = item;
            this.num = N;
        }
        @Override
        public boolean hasNext() {
            return num > 0;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            int rand = StdRandom.uniform(num);
            Item tmp = items[rand];
            items[rand] = items[num - 1];
            items[num - 1] = tmp;
            num--;
            return tmp;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
