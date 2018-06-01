package test.chap1.chap1_3;

import edu.princeton.cs.algs4.In;
import txt.chap1.chap1_3.Stack;

/**
 * chap 1_3_4  测试用例
 */
public class Parentheses {
    //命令行参数为 testChap1_1_4.txt
    //java Parentheses testChap1_1_4.txt
    public static void main(String[] args) {
        String[] arr = In.readStrings(args[0]); //可以直接更改为In.readStrings("testChap1_1_4.txt");
        Stack<String> stack = new Stack<>();
        for (String inputStr :
                arr) {
            if ("(".equals(inputStr)||
                    "[".equals(inputStr)||
                    "{".equals(inputStr)){
                stack.push(inputStr);
            }else if (")".equals(inputStr)||
                    "]".equals(inputStr)||
                    "}".equals(inputStr)){
                if (stack.isEmpty()){   //为空还有右边符号，证明错误
                    System.out.println(false);
                    return;
                }
                boolean flag = checkPattern(stack, inputStr);
                if (!flag){
                    System.out.println(false);
                    return;
                }
            }
        }
        if (!stack.isEmpty()){//证明还有左边符号，错误
            System.out.println(false);
        }else {
            System.out.println(true);
        }
    }
    private static boolean checkPattern(Stack<String> stack, String str){
        boolean flag = false;
        String firstStr = stack.pop();
        if (str.equals(")") && firstStr.equals("(")){
            flag = true;
        }else if (str.equals("]") && firstStr.equals("[")){
            flag = true;
        }else if (str.equals("}") && firstStr.equals("{")){
            flag = true;
        }
        return flag;
    }
}
