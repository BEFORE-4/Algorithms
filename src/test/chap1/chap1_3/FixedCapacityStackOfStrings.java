package test.chap1.chap1_3;

/**
 * chap1_3_1
 */
public class FixedCapacityStackOfStrings {
    private String[] cap;//栈
    private int N;  //栈尺寸
    FixedCapacityStackOfStrings(int cap){
        this.cap = new String[cap];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void push(String item){
        cap[N++] = item;
    }
    String pop(){
        return cap[--N];
    }
    //添加isFull()方法
    public boolean isFull(){
        return N == cap.length;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings test = new FixedCapacityStackOfStrings(2);
        System.out.println(test.isEmpty());
        test.push("1");
        System.out.println(test.isFull());
        test.push("2");
        System.out.println(test.isFull());
    }
}
