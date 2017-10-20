package test.chap1.chap1_1;

import edu.princeton.cs.algs4.StdRandom;

public class Test1_1_35 {
    public static void main(String[] args) {
        double[] theory = getNum();
        //1 000 000 次基本上达到小数点后三位吻合
        double[] fact = simulate(1000000);
        for (int i = 2; i < theory.length; i++) {
            System.out.println(fact[i] + "\t" +theory[i] );
        }
    }
    static double[] getNum(){
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES ; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i + j] += 1.0;
            }
        }
        for (int k = 2; k <= 2 * SIDES ; k++) {
            dist[k] /= 36.0;
        }
        return dist;
    }
    static double[] simulate(int N){
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 0; i < N; i++) {
            int num1 = StdRandom.uniform(1, 7);
            int num2 = StdRandom.uniform(1, 7);
            dist[num1 + num2] += 1.0;
        }
        for (int i = 2; i < dist.length; i++) {
            dist[i] /= N;
        }
        return dist;
    }
}
