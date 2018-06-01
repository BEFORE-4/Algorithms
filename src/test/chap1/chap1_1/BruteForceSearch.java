package test.chap1.chap1_1;

import edu.princeton.cs.algs4.In;


public class BruteForceSearch {
    //360万数据量最后一个给值9999大约6ms
    public static void main(String[] args) {
        In in = new In("txtFile/largeT.txt");
        int[] whitelist = in.readAllInts();
        long start = System.currentTimeMillis();
        System.out.println(start);
        int num = forceSearch(9999, whitelist);
        long end = System.currentTimeMillis();
        System.out.println(end);
        if (num == -1){
            System.out.println("can't find");
        }else {
            System.out.println(num);
        }
        System.out.println((end -start));
    }
    public static int forceSearch(int key, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}
