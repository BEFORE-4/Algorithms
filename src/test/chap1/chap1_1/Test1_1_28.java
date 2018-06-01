package test.chap1.chap1_1;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.List;

public class Test1_1_28 {
    //参数 txtFile/largeT.txt
    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        Integer[] temp = modify(whitelist);
        List list = Arrays.asList(temp);
        list.forEach((e) -> {
            if (e != null){
                System.out.print(e + "\t");
            }
        });
    }
    public static Integer[] modify(int[] whitelist){
        Integer[] temp = new Integer[whitelist.length];
        int k = 0;
        flag:
        for (int i = 0; i < whitelist.length; i++) {
            for (int j = 0; j < i; j++) {
                if (temp[j] != null && temp[j] == whitelist[i]){
                    continue flag;
                }
            }
            temp[k++] = whitelist[i];
        }
        return temp;
    }
}
