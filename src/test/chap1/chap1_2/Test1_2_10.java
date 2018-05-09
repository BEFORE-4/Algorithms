package test.chap1.chap1_2;

import edu.princeton.cs.algs4.StdDraw;

public class Test1_2_10 {
    public static void main(String[] args) {
        VisualCounter counter = new VisualCounter(4, 12);
        counter.add();
        counter.add();
        counter.add();
        counter.add();
        counter.add();
        counter.minus();
        int result = counter.getResult();
        System.out.println(result);
    }
}
class VisualCounter{
    private int N;  //操作最大次数
    private int max;    //计数器的最大绝对值
    private int num = 0;    //计数器的操作次数
    private int sum = 0;    //计数器的值
    VisualCounter(int N, int max){
        this.N = N;
        this.max = max;
        //画图板X在0和最大次数之间，Y在最大绝对值正负之间
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-max, max);
        StdDraw.setPenRadius(0.01);
    }
    //加1
    protected void add(){
        if (num == N){
            System.out.println("操作次数超限");
            return;
        }
        if (Math.abs(sum) == max){
            System.out.println("最大绝对值超限");
            return;
        }
        num++;
        sum++;
        StdDraw.point(num, sum);
    }
    //减1
    protected void minus(){
        if (num == N){
            System.out.println("操作次数超限");
            return;
        }
        if (Math.abs(sum) == max){
            System.out.println("最大绝对值超限");
            return;
        }
        num++;
        sum--;
        StdDraw.point(num, sum);
    }
    //返回结果
    protected int getResult(){
        return sum;
    }
}