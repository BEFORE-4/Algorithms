package test.chap1.chap1_1;

public class Test1_1_14 {
    public static void main(String[] args) {
        int num = lg(31);
        System.out.println(num);
    }
    public static int lg(int N){
        int num = 1;
        for(int i = 0; i <= N; i++){
            num *= 2;
            if (num > N){
                num = i;
                break;
            }
        }
        return num;
    }
}
