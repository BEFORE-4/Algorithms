package test.chap1.chap1_2;

import edu.princeton.cs.algs4.In;

public class Test1_2_15 {
    public static void main(String[] args) {
        int[] result = readInts("txtFile/whitelist.txt");
        for (int index :
                result) {
            System.out.println(index);
        }
    }
    public static int[] readInts(String name){
        In in = new In(name);
        String str = in.readAll();
        String[] arr = str.split("\\s+");   //空格、回车、制表符等空白
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Integer.parseInt(arr[i]);
        }
        return result;
    }
}
