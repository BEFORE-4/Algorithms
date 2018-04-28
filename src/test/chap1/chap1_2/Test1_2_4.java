package test.chap1.chap1_2;

import edu.princeton.cs.algs4.StdOut;

public class Test1_2_4 {
   /*值传递,打印出
    world
    hello
    */
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
