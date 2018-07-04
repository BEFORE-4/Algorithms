package test.chap1.chap1_3;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayDeque<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        ResizingArrayDeque<String> result = new ResizingArrayDeque<>();
        result.pushLeft("a");
        result.pushLeft("b");
        result.pushLeft("c");
        result.pushLeft("d");
        result.pushLeft("d");
        String left = result.popLeft();
        result.pushLeft("left");
        String right = result.popRight();
        result.pushRight("right");
        result.pushLeft("dd");
    }
    private Item[] data;    //数据
    private int N;  //尺寸
    private int left;   //最左边数据索引
    private int right;  //最右边数据索引

    /**
     * 初始化尺寸为2
     */
    ResizingArrayDeque(){
        data = (Item[])new Object[2];
        N = 0;
        left = 0;
        right = 0;
    }
    boolean isEmpty(){
        return N == 0;
    }
    int size(){
        return N;
    }
    void pushLeft(Item item){
        if (N == data.length)
            resize(N * 2);  //元素数量到极限扩容为原来两倍
        if (left == 0){
            left = data.length - 1;     //到最左边时，循环到数组尾部添加元素
        }else {
            left--;
        }
        data[left] = item;
        N++;
    }
    void pushRight(Item item){
        if (N == data.length)
            resize(N * 2);      //元素数量到极限扩容为原来两倍
        if (right == data.length - 1)
            right = 0;      //到最右边时，循环到数组头部添加元素
        else
            right++;
        data[right] = item;
        N++;
    }
    Item popLeft() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException("no element!");
        }
        if (N == data.length / 4)
            resize(data.length / 2);    //尺寸到四分之一时，数组尺寸减小
        Item item = data[left];
        if (left == data.length - 1)
            left = 0;   //已经是尾部元素取出时，left变为第一个元素
        else
            left++;
        N--;
        return item;
    }
    Item popRight() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException("no element!");
        }
        if (N == data.length / 4)
            resize(data.length / 2);
        Item item = data[right];
        if (right == 0)
            right = data.length - 1;
        else
            right--;
        N--;
        return item;
    }
    void resize(int capacity){
        Item[] arr = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            arr[i] = data[ (i + left) % data.length];
        }
        data = arr;
        left = 0;
        right = N - 1;
    }
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    class DequeIterator implements Iterator<Item>{
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < N;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = data[(index + left) % data.length];
            index++;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
