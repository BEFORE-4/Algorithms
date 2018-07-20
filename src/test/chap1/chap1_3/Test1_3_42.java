package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * 复制栈
 */
public class Test1_3_42 {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        Stack<String> s = new Stack<>();
        s.push(a);  //两者都有效
        s.push(b);  //两者都有效
        StdOut.println("s的尺寸为：" + s.size);
        for (String str : s) {
            StdOut.print(str + '\t');
        }
        StdOut.println();
        Stack<String> t = new Stack<>(s); //复制栈
        s.push(c);      //只对s有效
        s.pop();    //只对s有效
        t.push("d"); //只对t有效
        t.push("e");    //只对t有效
        StdOut.println("t的尺寸为：" + t.size);
        for (String str :
                t) {
            StdOut.print(str + '\t');
        }
    }
}
