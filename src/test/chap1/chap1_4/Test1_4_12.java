package test.chap1.chap1_4;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Test1_4_12 {

    public static void main(String[] args) {
        //此时为最坏运行次数。一个数组中除最大值比另一个数组大外，其他值都很小
        //运行次数为2N-1
        int[] a1 = {100,101,102,102,106,107,109,192,105,107,999};
        int[] b1 = {1,2,3,4,5,6,7,8,9,10,1000};
        Arrays.sort(a1);
        Arrays.sort(b1);
        printSame(a1, b1);
    }
    /**
     * 有序地打印两个有序数组中所有公共元素(两个数组长度相等)
     * 将两个数组从索引为0时的值开始比较。如果相等，两个索引都加1再比较。
     * 否则，将较小值对应的数组索引加1再比较。
     * @param a 比较的有序数组
     * @param b 比较的有序数组
     */
    private static void printSame(int[] a, int[] b){
        int N = a.length;
        int num = 0;    //记录运行次数
        for (int i = 0, j = 0; i < N && j < N; ) {
            num++;  //运行次数加1
            //索引对应值较小时，索引加1.相等时，两个索引分别加1
            if (a[i] > b[j])
                j++;
            else if (a[i] < b[j]){
                i++;
            }else {
                StdOut.print(a[i] + "\t");
                j++;
                i++;
            }
        }
        //打印运行次数和数组长度
        StdOut.println();
        StdOut.println("a的长度为：" + N + "\n运行次数为:" + num);
    }
}
