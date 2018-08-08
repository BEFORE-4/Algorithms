package test.chap1.chap1_4;

import edu.princeton.cs.algs4.StdOut;

public class Test1_4_17 {

    public static void main(String[] args) {
        double[] a = {1.2, 1.2, 2.3, 49.2, -2, 0.3};
        String result = getFarest(a);
        String[] str = result.split("\\|");
        StdOut.println("两个数为： " + str[0] + "\t" + str[1]);
        StdOut.println("最大差为： " + str[2]);
    }

    /**
     * 对给定的数组，找出两者之差(绝对值)最大的两个数
     * @param a 给定的数组
     * @return  字符串包含最小值，最大值，差值。它们用|分割开
     */
    public static String getFarest(double[] a){
        int N = a.length;
        double min = a[0];
        double max = a[0];
        for (int i = 1; i < N - 1; i++) {
            if (min > a[i])
                min = a[i];
            if (max < a[i])
                max = a[i];
        }
        double diff = Math.abs(max - min);
        return min + "|" + max + "|" + diff;
    }
}
