package test.chap1.chap1_2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class Test1_2_9 {
//txt文档中的数据不能太多，否则执行会很慢。用largeT.txt执行，数据将近400w，很久没有出结果
//将文档换成 whitelist.txt 执行，数据只有10个左右
// java Test1_2_9 txtFile/whitelist.txt
    public static void main(String[] args) {
        In in = new In(args[0]);   //参数为  whitelist.txt
        int[] whitelist = in.readAllInts(); //读取文件转换为数组
        Arrays.sort(whitelist);
        int num = 12;   //查找12有几个
        Counter counter = new Counter("keys");
        int index = rank(num, whitelist);   //12在数组中的索引
        while (index != -1){
            counter.increment();    //每有一个12，加1
            whitelist[index] = 0;   //将该位置的12更改为0，排序后继续查找
            Arrays.sort(whitelist);
            index = rank(num, whitelist);
        }
        System.out.println(counter.tally());
    }
    /**
     * 二分法查找
     * @param a
     * @param key
     * @return
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    }

}
