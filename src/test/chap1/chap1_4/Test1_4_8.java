package test.chap1.chap1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import txt.chap1.chap1_4.Stopwatch;

import java.util.Arrays;

public class Test1_4_8 {
    public static void main(String[] args) {
        String txt = "txtFile/8Kints.txt";
        int[] a = In.readInts(txt);
        Stopwatch timer = new Stopwatch();
        int num = getEqualNum(a);
        double time = timer.elapsedTime();
        StdOut.println("普通算法:\n" + num + "\n" + time);
        timer = new Stopwatch();
        num = quickGet(a);
        time = timer.elapsedTime();
        StdOut.println("改进算法:\n" + num + "\n" + time);
    }
    public static int getEqualNum(int[] a){
        int num = 0;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i] == a[j])
                    num++;
            }
        }
        return num;
    }
    //主要逻辑是用二分法
    public static int quickGet(int[] a){
        int num = 0;
        Arrays.sort(a);
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //二分法查找后，注意对重复元素进行判断
            //数据量比较大，重复元素较少时，时间主要消耗在该处。更接近logN
            int index = BinarySearch.indexOf(a, a[i]);
            if (index > i){
                num++;
            }else if(index < i){    //防重复，索引不能小于元素位置
                index = i;
            }
            int index1 = index;
            //拿到的相等元素的索引判断左右两边是否和该元素相等。但是最左边位置必须大于元素位置，防重复
            //左边的数量
            while(--index > i && a[i] == a[index]){
                num++;
            }
            //右边的数量
            while(++index1 < a.length - 1 && a[i] == a[index1]){
                num++;
            }
        }
        return num;
    }
}