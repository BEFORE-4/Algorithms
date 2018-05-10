package test.chap1.chap1_2;

public class Test1_2_17 {
    //intellij默认关闭断言，所以需要开启断言
    //开启方法：在Edit Configurations中，将VM options设置为 -ea
    public static void main(String[] args) {
        // Rational在同级包下
        Rational rational1 = new Rational(0xffffffff, 1);
        Rational rational2 = new Rational(0xffffffff, 1);
        System.out.println(rational1.plus(rational2));  //相加溢出后断言报错退出
    }
}
