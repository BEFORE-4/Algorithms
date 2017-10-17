package test.chap1.chap1_1;

public class Test1_1_9 {
    public static void main(String[] args) {
        String s = "";
        int N = 8;
        System.out.println(Integer.toBinaryString(N));
        for (int n = N; n > 0; n /= 2){
            s = (n % 2) + s;
        }
        System.out.println(s);
    }
}
