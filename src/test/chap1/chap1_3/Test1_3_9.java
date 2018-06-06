package test.chap1.chap1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import txt.chap1.chap1_3.Stack;

public class Test1_3_9 {
    @Deprecated
    public static void main(String[] args) {
        String[] strs = In.readStrings("txtFile/testChap1_1_9.txt");
        Stack<String> marks = new Stack<>();    //只装符号
        Stack<String> nums = new Stack<>();    //只装数组
        for (String str : strs) {
            //正则表达式判断是数字，装入数字栈；默认等式文件正确，除数字以外为运算符和括号
            if (str.matches("\\d+")){
                nums.push(str);
            }else if (str.equals(")")){
                String num1 = nums.pop();
                String num2 = nums.pop();
                String newNum = "(" + num2 + marks.pop() + num1 + ")";
                nums.push(newNum);
            }else {
                marks.push(str);
            }
        }
        for (String str : nums) {
            StdOut.print(str + "\t");
        }
    }
}
