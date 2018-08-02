package txt.chap1.chap1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import test.chap1.chap1_4.Test1_4_3;

/**
 * 自己电脑运行结果为
 *
 250   0.0
 500   0.1
 1000   0.1
 2000   0.9
 4000   5.0
 8000  37.9
 估算16000 为303.2 实际为 306.5
 用16000的结果估算32000 时间为2452 40多分钟 实际为  2497.4
 64000 为 19616 5个多小时，没有必要验证
 */
public class DoublingTest {
    public static double timeTrial(int N){
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args) {
        int[] n = new int[6];
        double[] times = new double[6];
        int i = 0;
        for (int N = 250; N < 9000; N += N){
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
            n[i] = N;
            times[i++] = time;
        }
//按理来说，画图方法并不会影响上面的执行效率。但实际上在用drawLog画图时，上面代码执行时间变慢
        Test1_4_3.drawLog(n, times);//画图
    }
}
