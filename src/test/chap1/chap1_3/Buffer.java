package test.chap1.chap1_3;

import java.util.NoSuchElementException;

public class Buffer{
    private Stack<Character> buffer, current;//两个栈，一个缓冲，一个现在内容
    Buffer(){
        buffer = new Stack<>();
        current = new Stack<>();
    }
    void insert(char c){
        buffer.push(c);
        current.push(c);
    }
    char delete(){
        if (current.size == 0){
            throw new NoSuchElementException("no element");
        }
        buffer.pop();
        return current.pop();
    }
    void left(int k){
        if (k > current.size){
            throw new NoSuchElementException("no so many elements");
        }
        for (int i = 0; i < k; i++) {
            current.pop();
        }
    }
    void right(int k){
        if (k > (buffer.size - current.size)){
            throw new NoSuchElementException("no so many elements");
        }
        Stack<Character> clone = new Stack<>(buffer);//克隆一个缓冲栈
        Stack<Character> tmp = new Stack<>();
        int diffSize = buffer.size - current.size - k; //光标向右移动后两者尺寸差
        //pop出两者尺寸差的元素。这些元素这次没有用
        if (diffSize > 0){
            for (int i = 0; i < diffSize; i++){
                clone.pop();
            }
        }
        //两次for循环抵消栈的先进后出，以使结果正确
        for (int i = 0; i < k; i++) {
            tmp.push(clone.pop());
        }
        for (int i = 0; i < k; i++) {
            current.push(tmp.pop());
        }
    }
    int size(){
        return current.size;
    }
}
