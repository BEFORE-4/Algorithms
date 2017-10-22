package test.chap1.chap1_1;

import edu.princeton.cs.algs4.StdRandom;
import txt.chap1.BinarySearch;

import java.util.Arrays;

public class Test1_1_39 {
    //命令行参数为 100
    public static void main(String[] args) {
        int T = Integer.valueOf(args[0]);
        int[] N = {1000, 10000, 100000, 1000000};
        int[] num = new int[4];     //四个分别代表上面四个N所对应的数组重复数
        for (int j = 0; j < T; j++) {
            for (int i = 0; i < N.length; i++) {
                num[i] += getNumByN(N[i]);
            }
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]/T + "\t"); //输出时候数量平均值
        }
    }
    //获得数组，并得到相同数的数量
    public static int getNumByN(int N){
        int[] arr1 = initArr(N);
        int[] arr2 = initArr(N);
        int num = getSameNum(arr1, arr2);
        return num;
    }
    //初始化数组
    public static int[] initArr(int N){
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform(100000, 1000000);
        }
        return arr;
    }
    //得到两个数组中相同数的数量
    public static int getSameNum(int[] arr1, int[] arr2){
        int num = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int item :
                arr1) {
            if (BinarySearch.indexOf(arr2, item) != -1)
                num++;
        }
        return num;
    }
}
