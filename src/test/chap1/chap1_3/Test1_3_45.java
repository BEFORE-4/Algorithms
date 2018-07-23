package test.chap1.chap1_3;

public class Test1_3_45 {
    public static void main(String[] args) {
        //测试数组是否向下溢出
        String[] str = {"-", "0", "1"};
        testSpill(str);
       //测试能否生成给的的排列
        String[] sequence = {"0","1","2","5","3","4"};
        boolean a = testSequence(sequence);
        System.out.println(a);
    }
    public static void testSpill(String[] str){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if ("-".equals(str[i])){
                try {
                    stack.pop();
                }catch (NullPointerException e){
                    System.out.println("array underflow");  //产生异常代表溢出，则结束程序
                    return;
                }
            }else {
                stack.push(str[i]);
            }
        }
    }
    public static boolean testSequence(String[] str){
        Stack<String> stack = new Stack<>();
        int tmp = 0;
        for (int i = 0; i < str.length; i++) {
            if (stack.size == 0 || !str[i].equals(stack.peek())){
                //已经增加的数量等于排列数组大小，不能再增加
                if (tmp >= str.length)
                    break;
                stack.push(Integer.valueOf(tmp++).toString());
                i--;
            }else{
                stack.pop();
            }
        }
        return stack.size == 0;
    }
}
