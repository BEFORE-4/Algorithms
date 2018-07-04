package test.chap1.chap1_3;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomBag<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        RandomBag<String> bag = new RandomBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("d");
        bag.add("e");
        bag.add("f");
        for (String str :
                bag) {
            StdOut.println(str);
        }
    }
    Item[] data;
    int N;
    int first;
    RandomBag(){
        data = (Item[]) new Object[2];
        N = 0;
        first = 0;
    }
    boolean isEmpty(){
        return N == 0;
    }
    int size(){
        return N;
    }
    void add(Item item){
        if (N == data.length){
            resize(data.length * 2);
        }
        if (!isEmpty())
            first++;
        N++;
        data[first] = item;
    }
    private void resize(int capacity){
        Item[] result = (Item[]) new Object[capacity];
        System.arraycopy(data, 0, result, 0, N);
        data = result;
    }
    @Override
    public Iterator<Item> iterator() {
        return new BagIterator(N, data);
    }
    class BagIterator implements Iterator<Item>{
        private int index = 0;
        private int num;
        private Item[] items;
        BagIterator(int N, Item[] data){
            this.num = N;
            this.items = data;
        }
        @Override
        public boolean hasNext() {
            return index < num;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            int randIndex = StdRandom.uniform(num); //随机一个索引，该位置的值和数组末尾
            Item tmp = items[randIndex];
            items[randIndex] = items[num - 1];
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
