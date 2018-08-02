package test.chap1.chap1_4;

import edu.princeton.cs.algs4.StdOut;

public class Test1_4_2 {
    public static void main(String[] args) {
        int a = -2147483648;
        int b = -2147483648;
        int c = 0;
        StdOut.println("正常情况下，会溢出造成错误:");
        StdOut.println(a + b + c);
        StdOut.println("强制转换为long可解决:");
        StdOut.println((long) a + b + c);
        //在数据量很大时候，执行方法会耗费很多时间
        StdOut.println("方法判断溢出返回-1也可解决：");
        StdOut.println(sum(a, b, c));
    }

    /**
     * 三个整数求和计算。如果两个整数相加有溢出情况，则求和返回-1，并打印overflow
     * @param a
     * @param b
     * @param c
     * @return  三数之和或者-1
     */
    public static int sum(int a, int b, int c){
        int big,mid,small;
        if (a >= b){
            big = a;
            small = b;
        }else{
            big = b;
            small = a;
        }
        if (big >= c){
            if (small >= c){
                mid = small;
                small = c;
            }else{
                mid = c;
            }
        }else{
            big = c;
            if (small == a)
                mid = b;
            else
                mid = a;
        }
        if (mid >= 0){
            if (big + mid < 0){
                System.out.println("overflow");
                return -1;  //溢出返回-1
            }
        }else{
            if (mid + small >= 0){
                System.out.println("overflow");
                return -1;  //溢出返回-1
            }
        }
        return a + b + c;
    }
}
