package test.chap1.chap1_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Test1_4_11
 */
public class StaticSETofInts {
    public static void main(String[] args) {
        int[] key = {1,2,3,2,3,4,56,7,8,9,4,5,6,7,8,9};
        StaticSETofInts a = new StaticSETofInts(key);
        StdOut.println(a.howMany(9));
    }

    /**
     * 查找给定键的出现次数
     * @param key 给定键的值
     * @return 返回出现次数
     */
    private int howMany(int key){
        int rank = rank(key);
        if (rank == -1)
            return 0;
        int rank1 = rank;
        int num = 1;
        //二分法查找到的索引之前与key相等的数量
        while (--rank >= 0 && a[rank] == key){
            num++;
        }
        //二分法查找到的索引之后与key相等的数量
        while (++rank1 < a.length && a[rank1] == key){
            num++;
        }
        return num;
    }
    private int[] a;
    public StaticSETofInts(int[] keys){
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }
    public boolean contains(int key){
        return rank(key) != -1;
    }
    private int rank(int key){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
