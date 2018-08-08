package test.chap1.chap1_4;


import edu.princeton.cs.algs4.StdOut;

/**
 * 找出数组局部最小值，并返回索引。
 *
 */
public class Test1_4_18 {
    public static void main(String[] args) {
        int[] a = {510, 223, 3, 4, 5, 6, 7, 5, 8};
        StdOut.println(getLocalMin(a));
    }
    /**
     * 找出一个局部最小元素 局部最小值满足  a[i]<a[i-1]&a[i]<a[i+1]
     * 时间复杂度为O(logN)
     * @param a 含有N个不同整数的数组
     * @return  返回局部最小值的索引，没有返回-1
     */
    public static int getLocalMin(int[] a){
        int lo = 0;
        int hi = a.length - 1;
        while (hi >= lo){
            int mid = lo + (hi - lo) / 2;
            if (mid == 0)
                return 0;
            else if (mid == a.length - 1)
                return a.length - 1;
            if (a[mid] < a[mid + 1] && a[mid] < a[mid - 1])
                return mid;
            else if (a[mid - 1] < a[mid + 1])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }
}
