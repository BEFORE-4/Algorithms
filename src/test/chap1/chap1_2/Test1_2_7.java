package test.chap1.chap1_2;

public class Test1_2_7 {
    public static void main(String[] args) {
        String a = "abcdefg";
        System.out.println(mystery(a)); //返回字符串 gfedcba
    }
    //返回值字符串倒序排列
    private static String mystery(String s){
        int N = s.length();
        if (N <= 1)
            return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }
}
