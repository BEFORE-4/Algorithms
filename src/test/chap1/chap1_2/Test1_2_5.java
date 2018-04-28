package test.chap1.chap1_2;

import edu.princeton.cs.algs4.StdOut;

public class Test1_2_5 {
    /**
   s不变，打印出Hello World
     */
    public static void main(String[] args) {
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        StdOut.println(s);
    }
}
