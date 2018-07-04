package test.chap1.chap1_3;

import java.util.NoSuchElementException;

public class GeneralizedQueue<Item> {
    Item[] data;
    int N;
    int index;
    GeneralizedQueue(){
        data = (Item[])new Object[2];
        N = 0;
        index = 0;
    }
    boolean isEmpty(){
        return N == 0;
    }
    void insert(Item x){
        if (N == data.length)
            resize(data.length * 2);
        if (!isEmpty())
            index++;
        N++;
        data[index] = x;
    }

    /**
     * k的大小为1到N
     * @param k 第k个元素需要删除
     * @return  删除的元素
     */
    Item delete(int k){
        if (k > N)
            throw new NoSuchElementException("下标错误");
        Item temp = data[k];
        for (int i = k - 1; i < N - 1; i++) {
            data[i] = data[i + 1];
        }
        data[N - 1] = null;
        N--;
        if(N == data.length / 4)
            resize(data.length / 2);
        return temp;
    }
    void resize(int capacity){
        Item[] result = (Item[])new Object[capacity];
        System.arraycopy(data, 0, result, 0, N);
        data = result;
    }
}
