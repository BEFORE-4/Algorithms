package test.chap1.chap1_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Test1_4_15 {
    public static void main(String[] args) {
        int[] a = {-9, -9, -9, -9, 0,0,0,1, 2, 3, 4, 5, 9, 9};
        Arrays.sort(a); //对数组排序
        StdOut.println(countThree(a));
    }

    /**
     * 计算一个已排序数组中两两相加为零的对数
     * @param a 已排序的数组
     * @return  相加为零的对数
     */
    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        for (int i = 0, j = N - 1; i < N && j > i;) {
            if (a[i] + a[j] < 0){   //左边比较小，左边索引加1
                i++;
            }else if (a[i] + a[j] > 0){
                j--;        //右边比较大，右边索引减1
            }else {
                cnt++;
                if (a[i] == a[i + 1] && a[j] != a[j - 1]){
                    i++;    //左边数下一位与之相等，并且右边数上一位与其不相等，左边索引加1
                }else if (a[i] != a[i + 1] && a[j] == a[j - 1]){
                    j--;    //左边数下一位与之不相等，并且右边数上一位与其相等，右边索引减1
                }else if (a[i] != a[i + 1] && a[j] != a[j - 1]){
                    i++;    //左右两边与其旁边数都不相等，索引都变化
                    j--;
                }else { //左右两边与其旁边数都相等，则需要遍历一次相等的数，再变更索引
                    int index = i;
                    while (a[++index] == a[i] && index < j) {
                        cnt++;
                    }
                    j--;
                }
            }
        }
        return cnt;
    }

    public static int countThree(int[] a){
        int cnt = 0;
        int N = a.length;
        for (int k = 0; k < N - 3; k++) {
            for (int i = k + 1, j = N - 1; i < N && j > i;) {   //防止重复计算，需要取大于外部索引的值
                if (a[i] + a[j] + a[k] < 0){   //左边比较小，左边索引加1
                    i++;
                }else if (a[i] + a[j] + a[k] > 0){
                    j--;        //右边比较大，右边索引减1
                }else {
                    cnt++;
                    if (a[i] == a[i + 1] && a[j] != a[j - 1]){
                        i++;    //左边数下一位与之相等，并且右边数上一位与其不相等，左边索引加1
                    }else if (a[i] != a[i + 1] && a[j] == a[j - 1]){
                        j--;    //左边数下一位与之不相等，并且右边数上一位与其相等，右边索引减1
                    }else if (a[i] != a[i + 1] && a[j] != a[j - 1]){
                        i++;    //左右两边与其旁边数都不相等，索引都变化
                        j--;
                    }else { //左右两边与其旁边数都相等，则需要遍历一次相等的数，再变更索引
                        int index = i;
                        while (a[++index] == a[i] && index < j) {
                            cnt++;
                        }
                        j--;
                    }
                }
            }
        }
        return cnt;
    }
}
