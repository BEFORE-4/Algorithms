package txt.chap1.chap1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 350     0.0  2.0
 700     0.0  1.4
 1400     0.1  3.6
 2800     0.3  4.7
 5600     1.2  4.2
 11200     3.9  3.2
 22400    16.6  4.3
 44800    69.6  4.2
 */
public class DoublingRatio {
    public static double timeTrial(int N){
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSumFast.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int i = 350; true ; i += i) {
            double time = timeTrial(i);
            StdOut.printf("%6d %7.1f", i, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
