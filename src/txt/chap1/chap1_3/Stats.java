package txt.chap1.chap1_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        //一直会循环，不会停止。需要不停加
        //可以在此处加个标志符使其满足一定条件跳出循环
        while (!StdIn.isEmpty()){
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();
        double sum = 0.0;
        for (double x :
                numbers) {
            sum += x;
        }
        double mean = sum / N;
        sum = 0.0;
        for (double x :
                numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (N - 1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
