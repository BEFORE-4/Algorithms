package test.chap1.chap1_3;

public class Test1_3_47 {
    //栈的破坏性连接
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        Stack<String> another = new Stack<>();
        another.push("x");
        another.push("y");
        another.push("z");
        stack.catenation(another);//破坏性连接
    }
}
