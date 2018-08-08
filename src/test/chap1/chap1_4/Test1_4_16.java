package test.chap1.chap1_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Test1_4_16 {

    public static void main(String[] args) {
        double[] a = {1.2, 1.2, 2.3, 49.2, -2, 0.3};
        String result = getNearly(a);
        String[] str = result.split("\\|");
        StdOut.println("两个数为： " + str[0] + "\t" + str[1]);
        StdOut.println("最小差为： " + str[2]);
    }

    /**
     * 找到一对数组中两者之差最小的两个数以及他们的差值
     * @param a 给定数组
     * @return  返回两个数和差值，它们用|分割开
     */
    public static String getNearly(double[] a){
        Arrays.sort(a); //数组排序最坏运行时间为 O(NlogN)
        int N = a.length;
        String result = a[0] + "|" + a[1];
        double diff = Math.abs(a[0] - a[1]);
        for (int i = 1; i < N - 2; i++) {
            double value = Math.abs(a[i] - a[i + 1]);
            if (diff > value){
                diff = value;
                result = a[i] + "|" + a[i + 1] + "|" + diff;
            }
        }
        return result;
    }
}

