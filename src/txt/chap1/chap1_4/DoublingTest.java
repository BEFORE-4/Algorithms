package txt.chap1.chap1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

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
        for (int N = 250; true; N += N){
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}
