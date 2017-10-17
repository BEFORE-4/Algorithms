package test.chap1.chap1_1;

public class Test1_1_20 {
    public static void main(String[] args) {
        //当值为21会发生溢出
        System.out.println(Math.log(getResult(20)));
    }
    public static long getResult(int N){
        if (N == 1){
            return 1;
        }
        return N * getResult(N - 1);
    }
}
