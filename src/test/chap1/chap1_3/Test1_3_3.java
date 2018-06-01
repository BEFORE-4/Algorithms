package test.chap1.chap1_3;

public class Test1_3_3 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
//  0 1 2 3 4 |pop所有| 5 6 7 8 9                     结果|| 4 3 2 1 0 9 8 7 6 5
//  0 1 2 3 4 |pop| 5 6 |pop| 7 8 |pop5个| 9          结果|| 4 6 8 7 5 3 2 9 1 0 (原结果不可能)
//  0 1 2 |pop|3 4 5|pop| 6|pop| 7|pop2个| 8|pop| 9   结果|| 2 5 6 7 4 8 9 3 1 0
//  0 1 2 3 4|pop| 5|pop| 6|pop| 7|pop| 8|pop| 9      结果|| 4 3 2 1 0 5 6 7 8 9
//  0 1|pop| 2 |pop|3|pop| 4 |pop|5|pop| 6 |pop|7 8 9 结果|| 1 2 3 4 5 6 9 8 7 0
//  0 |pop|1 2 3 4 |pop|5 6 |pop3个|7 8 |pop|9        结果|| 0 4 6 5 3 8 7 2 1 9(原结果不可能)
//  0 1|pop| 2 3 4|pop| 5 6 7|pop| 8 9                结果// 1 4 7 9 8 6 5 3 2 0(原结果不可能)
//  0 1 2|pop2个| 3 4|pop2个| 5 6|pop2个| 7 8|pop2个|9 结果// 2 1 4 3 6 5 8 7 9 0
    }
}
