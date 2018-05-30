package txt.chap1.chap1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 需要在每个运算都加上括号，否则会有错误
 * (1+2*3+1) 需写成 ((1+(2*3))+1)
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();  //操作符
        Stack<Double> vals = new Stack<>(); //运算符
        while (!StdIn.isEmpty()){
            String s = StdIn.readString();
            if (s.equals("stop"))
                break;
            if (s.equals("(")){
                //不做处理
            }else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals("sqrt"))
                ops.push(s);
            else if (s.equals(")")){
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+"))
                    v = vals.pop() + v;
                else if (op.equals("-"))
                    v = vals.pop() - v;
                else if (op.equals("*"))
                    v = vals.pop() * v;
                else if (op.equals("/"))
                    v = vals.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);
                vals.push(v);
            }else
                vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}
