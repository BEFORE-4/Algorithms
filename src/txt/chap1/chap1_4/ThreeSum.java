package txt.chap1.chap1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 统计一个文件中所有和为0的三整数元组的数量
 * 整数文件用OutputTxt.java生成
 * 生成的文件在src/txtFile下 分别为1Kints.txt 2Kints.txt 4Kints.txt 8Kints.txt
 * 当查询4Kints.txt文件数量时，需要大致一分钟
 * 当查询8Kints.txt文件数量时，很久运行不出结果
 */
//java ThreeSum txtFile/1Kints.txt
//java ThreeSum txtFile/2Kints.txt
//java ThreeSum txtFile/4Kints.txt
//java ThreeSum txtFile/8Kints.txt
public class ThreeSum {
    public static void main(String[] args) {
        //不加参数可以用下面的一行放开注释代替参数
//        args[0] = "txtFile/1Kints.txt";
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }

    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if ((long)a[i] + a[j] + a[k] == 0)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}
