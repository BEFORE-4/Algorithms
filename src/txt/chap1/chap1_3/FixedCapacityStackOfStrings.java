package txt.chap1.chap1_3;

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
}
