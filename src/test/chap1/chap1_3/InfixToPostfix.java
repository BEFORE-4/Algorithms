package test.chap1.chap1_3;

import txt.chap1.chap1_3.Stack;
//  中序表达式 2*3/(2-1)+3*(4-1)
//  前序表达式 +/*23-21*3-41
//  后序表达式 23*21-/341-*+
/**
 * 中序表达式转为后序表达式
 * Test1_3_10
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        //表达式中的每个运算符和数字用空格隔开
        String infixStr = "2 * 3 / ( 2 - 1 ) + 3 * ( 4 - 1 )";
        String str = toPrix(infixStr);
        System.out.println("中序转后序的结果为:");
        System.out.println(str);
    }
    public static String toPrix(String infixStr){
        String[] arr = infixStr.split(" ");
        Stack<String> nums = new Stack<>();
        Stack<String> operats = new Stack<>();
        String equation = "";
        for (String str : arr) {
            if (str.matches("\\d")){    //如果是数字，直接输出
                nums.push(str);
                equation += str;
//                System.out.println(equation);   //每次有输出打印变化
            }else if (str.matches("\\)")){  //如果是 ) ，则一直弹出栈内的运算符，直到遇到 (
                while (!operats.peek().equals("(")){
                    equation += operats.pop();
                }
//                System.out.println(equation);   //每次有输出打印变化
                operats.pop();  //将 ( 从栈中弹出
            }else{
                if (operats.isEmpty()){ //操作符栈为空，直接压入
                    operats.push(str);
                }else if (higherThan(operats.peek(), str)){ //若操作符比栈顶操作符优先级高，直接压入
                    operats.push(str);
                }else {
                    //操作符栈不为空 && 栈顶元素不为( && 栈顶元素不大于操作符 ，则一直弹出
                    while ((!operats.isEmpty()) &&
                            (!higherThan(operats.peek(), str)) && (!"(".equals(operats.peek()))){
                        equation += operats.pop();
                    }
//                    System.out.println(equation);   //每次有输出打印变化
                    operats.push(str);  //将操作符压入栈
                }

            }
        }
        //将最后的运算符输出
        while (!operats.isEmpty()) {
            equation += operats.pop();
        }
        return equation;
    }

    /**
     * 判断两个符号的优先级,后者优先级高，返回true
     * @param str1 判断的第一个参数
     * @param str2 判断的第二个参数
     * @return 第二个参数优先级高，返回true；其余返回false
     */
    public static boolean higherThan(String str1, String str2){
        return (str2.equals("(")) ||
                ((str1.equals("+") || str1.equals("-")) &&
                        (str2.equals("*") || str2.equals("/")));
    }
}
