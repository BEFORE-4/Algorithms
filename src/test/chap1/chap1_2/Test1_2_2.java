package test.chap1.chap1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;

public class Test1_2_2{
//    正整数参数为间隔对数量,假设10个间隔对
//    java Test1_2_2 10
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] interval = new Interval1D[N];
        for (int i = 0; i < interval.length; i++) {
            System.out.println("请输入第 " + (i + 1) + "个间隔的一对double值");
            double min = StdIn.readDouble();
            double max = StdIn.readDouble();
            //第一个值比第二个值大,交换。否则创建对象会抛出异常
            if (min > max){
                min = min + max;
                max = min - max;
                min = min - max;
            }
            interval[i] = new Interval1D(min, max);
        }
        //两个间隔对相交,打印
        for (int i = 0; i < interval.length; i++) {
            for (int j = i + 1; j < interval.length; j++) {
                if (interval[i].intersects(interval[j])){
                    System.out.println("两个间隔相交 : (" + interval[i].min() + ", "
                    + interval[i].max() + ")  (" + interval[j].min() + ", " +
                        interval[j].max() + ")");
                }
            }
        }
    }
}
