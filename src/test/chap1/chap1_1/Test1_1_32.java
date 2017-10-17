package test.chap1.chap1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class Test1_1_32 {
    //    参数为  10  10.1  80.3
    // 因为 Test1_1_32.txt 中的数据是自己造的没有随机性，基本上是10-80之间
    public static void main(String[] args) {
        int N = Integer.valueOf(args[0]); // 分割N段
        double l = Double.valueOf(args[1]), r = Double.valueOf(args[2]); //起始位置和结束位置
        double[] arr = new double[10000];
        arr = In.readDoubles("Test1_1_32.txt");
        drawShape(arr, l, r, N);
    }

    /**
     * @param arr 输入流中的一系列double值
     * @param l 起始值
     * @param r 终止值
     * @param N (l,r)分为N段
     */
    private static void drawShape(double[] arr, double l, double r, int N){
        double len = (r - l ) / N; //每段长度
        int[] num = new int[N]; //记录每段的数量
        int max = 0; //记录各段中的最大值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > l && arr[i] < r){
                num[(int)((arr[i] - l) / len)]++;
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max){
                max = num[i];
            }
        }
        StdDraw.setXscale(l - 10, r + 10);
        StdDraw.setYscale(-5, max + 10);
        for (int i = 0; i < num.length; i++) {
            double a1 = l + len / 2 + len * i;  // x 坐标
            double a2 = num[i]/2;           //y 坐标
            double a3 = len / 2 * 0.9;    // x长度1/2 系数0.9使得每个直接有间距美观
            double a4 = num[i]/2;       // y长度的1/2
            StdDraw.filledRectangle(a1, a2, a3, a4);
        }
    }
}
