package test.chap1.chap1_1;

public class Test1_1_24 {
    public static void main(String[] args) {
        System.out.println(Euclid(105, 24));
        System.out.println(Euclid(1111111, 1234567));
    }
    public static int Euclid(int m, int n){
        System.out.println(m + "\t" + n);
        if (m % n == 0){
            return n;
        }else {
            return Euclid(n, m % n);
        }
    }
}
