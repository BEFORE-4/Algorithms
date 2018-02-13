package txt.chap1.chap1_2;


import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Rolls {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        final int SIDES = 6;
        Counter[] rolls = new Counter[SIDES + 1];
        for (int i = 0; i <= SIDES ; i++) {
            rolls[i] = new Counter(i + " 's");
        }
        for (int i = 0; i < T; i++) {
            int result = StdRandom.uniform(1, SIDES + 1);
            rolls[result].increment();
        }
        for (int i = 0; i <= SIDES ; i++) {
            StdOut.println(rolls[i]);
        }
    }
}
