package txt.chap1.chap1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
//java TwoSumFast txtFile/8Kints.txt
public class TwoSumFast {
    //该方法有缺陷。因为数组中可能含有重复元素
    public static int count(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            //在大于i的索引中查找-a[i]的索引，避免重复
            if (BinarySearch.rank(-a[i], a) > i)
                cnt++;
        }
        return cnt;
    }

    //普通方法。数组重复元素数量也会统计
    public static int count1(int[ ] a){
        int cnt = 0;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i] + a[j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
