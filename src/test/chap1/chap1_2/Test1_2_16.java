package test.chap1.chap1_2;


public class Test1_2_16 {
    public static void main(String[] args) {
        // Rational在同级包下
        Rational rational1 = new Rational(4, 6);
        Rational rational2 = new Rational(8, 12);
        System.out.println(rational1.plus(rational2));  //相加
        System.out.println(rational1.minus(rational2)); //相减
        System.out.println(rational1.times(rational2)); //相乘
        System.out.println(rational1.divides(rational2));   //相除
        Rational rational3 = new Rational(17,24);
        System.out.println(rational3.equals(rational2));    //比较是否相等
    }
}
