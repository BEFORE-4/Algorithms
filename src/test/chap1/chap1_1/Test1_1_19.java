package test.chap1.chap1_1;

import edu.princeton.cs.algs4.StdOut;

public class Test1_1_19 {
    public static long F(int N){
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }
    public static void main(String[] args) {
        //递归调用时间太长了
       /* for (int i = 0; i < 100; i++) {
            StdOut.println(i + " " + F(i));
        }*/
        //其实非递归调用
        long[] arr = getArr(100);
        for (int i = 0; i < arr.length; i++) {
            // i = 93 时已经发生溢出
            StdOut.println(i + " " + arr[i]);
        }
    }
    public static long[] getArr(int N){
        long[] arr = new long[N];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0){
                arr[i] = 0;
            }else if (i == 1){
                arr[i] = 1;
            }else {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
        }
        return arr;
    }
}
