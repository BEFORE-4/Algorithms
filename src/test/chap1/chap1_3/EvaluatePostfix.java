package test.chap1.chap1_3;

import txt.chap1.chap1_3.Queue;

import java.util.NoSuchElementException;

/**
 * 求后序表达式的运算结果
 * Test1_3_11
 */
public class EvaluatePostfix {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        String infixStr = "2 * 3 / ( 2 - 1 ) + 3 * ( 4 - 1 )";
        String str = InfixToPostfix.toPrix(infixStr);
        for (int i = 0; i < str.length(); i++) {
            queue.enqueue(String.valueOf(str.charAt(i)));
        }
        Double result = getResult(queue);
        System.out.println(result);
    }
    public static double getResult(Queue<String> queue){
        Stack<String> res = new Stack<>();
        double result, tmp;
        while (!queue.isEmpty()){
            String first = queue.dequeue();
            //如果是数字，直接入栈
            if (first.matches("\\d+((.)\\d+)?")){
                res.push(first);
//                System.out.println("number");
            }else{
                //如果是操作符，直接和栈中的数据进行处理，并将结果入栈
                tmp = Double.parseDouble(res.pop());
                result = Double.parseDouble(res.pop());
                result = changeResult(result, tmp, first);
                res.push(String.valueOf(result));
            }
            //队列为空，证明执行完成
            if (queue.isEmpty())
                break;
        }
        return Double.valueOf(res.pop());
    }
    static double changeResult(double beforeNum, double laterNum, String flag){
        switch (flag){
            case "+":
//                System.out.println(beforeNum  + " + " + laterNum);
                return beforeNum + laterNum;
            case "-":
//                System.out.println(beforeNum  + " - " + laterNum);
                return beforeNum - laterNum;
            case "*":
//                System.out.println(beforeNum  + " * " + laterNum);
                return beforeNum * laterNum;
            case "/":
//                System.out.println(beforeNum  + " / " + laterNum);
                return beforeNum / laterNum;
            default:
                throw new NoSuchElementException("flag wrong!");
        }
    }
}
