package test.chap1.chap1_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Test1_4_10 {
    public static void main(String[] args) {
        int[] a = {1, 1,2,3,3,2, 2,2,2,2,2,2,22,3};
        Arrays.sort(a);
        StdOut.println(getIndex(a, 2));
    }
    public static int getIndex(int[] a, int key){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            //如果该索引值等于key，进行下面判断
            else {
                int index = mid;
                if (--index >= lo && key == a[index])   //前一位元素和key相等，则继续二分查找
                    hi = index;
                else
                    return mid;
            }
        }
        return -1;
    }
}
