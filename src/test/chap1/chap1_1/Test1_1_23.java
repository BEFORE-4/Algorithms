package test.chap1.chap1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
public class Test1_1_23 {
    // 参数为 largeT.txt -   或者   largeT.txt +
    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        String endFlag = args[1];
        while (!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if ("+".equals(endFlag)){
                if (rank(key, whitelist) == -1){
                    StdOut.println(key);
                }
            }else if ("-".equals(endFlag)){
                if (rank(key, whitelist) != -1){
                    StdOut.println(key);
                }
            }

        }

    }
    public static int rank(int key, int[] a){
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
