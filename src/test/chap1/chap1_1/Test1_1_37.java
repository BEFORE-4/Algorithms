package test.chap1.chap1_1;

import edu.princeton.cs.algs4.StdRandom;

public class Test1_1_37 {
    //命令行参数  10 100000
    public static void main(String[] args) {
        int M = Integer.valueOf(args[0]),N = Integer.valueOf(args[1]);
        double[] arr;
        int[][] num = new int[M][M];
        for (int i = 0; i < N; i++) {
            arr = initArr(M);   //初始化数组
            shuffle(arr);   //打乱数组
            changeNum(arr, num);  //用num记录数组各值的次数
        }
//        打印输出 M*M 表格
        for (int[] item:num) {
            for (int number:item){
                System.out.print(number + "\t");
            }
            System.out.println();
        }
    }
    //    记录数组i在打乱后落到j位置的次数
    public static void changeNum(double[] arr, int[][] num){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == j){
                    num[i][j]++;
                    break;
                }
            }
        }
    }
    public static double[] initArr(int M){
        double[] arr = new double[M];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }
    //表1.1.10方法更改,打乱数组
    public static void shuffle(double[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //换为 0到N-1
            int r = StdRandom.uniform(0, N);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
