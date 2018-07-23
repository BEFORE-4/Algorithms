package test.chap1.chap1_3;

public class Test1_3_46 {
    public static void main(String[] args) {
        String[] str = {"3" , "1", "2"};
        Stack<Integer> stack = new Stack<>();
        stack = getStack(str);
    }
    public static Stack<Integer> getStack(String[] str){
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.valueOf(str[0]));
        for (int i = 1; i < str.length; i++){
            if (Integer.valueOf(str[i]) > stack.peek()){
                stack.push(Integer.valueOf(str[i]));
            }else{
                throw new UnsupportedOperationException("压入的元素没有栈顶元素大");
            }
        }
        return stack;
    }
}
