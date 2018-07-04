package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;

public class RingBuffer<Item> {
    public static void main(String[] args) {
        RingBuffer<String> buffer = new RingBuffer<>(5);
        buffer.enque("a");
        buffer.enque("b");
        buffer.enque("c");
        buffer.enque("d");
        buffer.enque("c");
        buffer.enque("d");
        StdOut.println(buffer.deque());
        buffer.enque("c");
        buffer.enque("d");
        StdOut.println(buffer.deque());
        buffer.enque("e");
        buffer.enque("f");
        buffer.enque("g");
        StdOut.println(buffer.deque());
        StdOut.println(buffer.deque());
        buffer.enque("h");
        StdOut.println(buffer.deque());
    }
    private int N;  //环形缓冲区尺寸
    Item[] data;    //存储数据
    int first;  //第一个数据索引位置
    int last;   //最后一个数据索引位置
    RingBuffer(int size){
        this.N = 0;
        this.first = 0;
        this.last = 0;
        this.data = (Item[]) new Object[size];
    }
    boolean isEmpty(){
        return N == 0;
    }
    boolean isFull(){
        return N == data.length;
    }
    public int size(){
        return N;
    }
    void enque(Item item){
        if (isFull()){
            StdOut.println("full! please wait!!");
            return;
        }
        if (!isEmpty()){
            last++;
            if (last >= data.length)
                last = last % data.length;
        }
        N++;
        data[last] = item;
    }
    Item deque(){
        if (isEmpty()){
            StdOut.println("empty! please wait!!");
            return null;
        }
        N--;
        Item item = data[first];
        first++;
        if (first >= data.length){
            first = first % data.length;
        }
        return item;
    }
}
