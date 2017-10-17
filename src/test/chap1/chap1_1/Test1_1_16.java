package test.chap1.chap1_1;

public class Test1_1_16 {
    public static void main(String[] args) {
        System.out.println(exRl(6));
    }
    public static String exRl(int n){
        if (n <= 0) return "";
        return exRl(n - 3) + n + exRl(n - 2) + n;
    }
}
