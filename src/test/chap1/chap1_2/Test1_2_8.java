package test.chap1.chap1_2;

public class Test1_2_8 {
    //数组交换是更改引用，数组并没有做更改
    public static void main(String[] args) {
        int a[] = new int[1000000];
        int b[] = new int[1000000];
        int [] t = a;
        a = b;
        b = t;
    }
}
