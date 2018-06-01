package test.chap1.chap1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import txt.chap1.chap1_3.FixedCapacityStack;

public class Test1_3_8 {
    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(2);
        //读取文件内容
        String[] strs = In.readStrings("txtFile/testChap1_1_8.txt");
        for (String str : strs) {
            if ("-".equals(str)){
                stack.pop();
            }else {
                stack.push(str);
            }
        }
        StdOut.println("数组大小:" + stack.size());
        StdOut.print("数组内容：");
        for (String str : stack) {
            StdOut.print(" " + str);
        }
    }
}
