package txt.chap1.chapTest;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import txt.chap1.chap1_2.Accumulator;

public class TetstAccmulator {
    //intellij idea 中配置程序参数1000 结果为  Mean{1000 values}: 0.48689
    //intellij idea 中配置程序参数1000000 结果为  Mean{1000000 values}: 0.50017
    //intellij idea 中配置程序参数100000000 结果为  Mean{1000000 values}: 0.49999
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Accumulator a = new Accumulator();
        for (int i = 0; i < T; i++) {
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }
}
