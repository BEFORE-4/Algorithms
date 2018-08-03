package test.chap1.chap1_4;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

public class Test1_4_14 {
    /**
     * 内部没有二分法
     */
    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        if ((long)a[i] + a[j] + a[k] + a[l] == 0)
                            cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    /**
     * 内部有二分法
     */
    public static int quickCount(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (BinarySearch.rank(-a[i] - a[j] - a[k], a) > k){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
