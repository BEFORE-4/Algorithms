package test.chap1.chap1_1;

import java.util.Arrays;

public class Test1_1_29 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,23,12,34,213,34,123,34,213,12,43,54,645,76,87,9};
        Arrays.sort(arr);
        int num = rank(213, arr);
        int cout = count(213, arr);
        System.out.println(num);
        System.out.println(cout);
    }
    private static int rank(int k, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (k <= arr[i])
                return i;
        }
        return arr.length;
    }
    private static int count(int k, int[] arr){
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (k == arr[i])
                num++;
            else if (k < arr[i])
                break;
        }
        return num;
    }
}
