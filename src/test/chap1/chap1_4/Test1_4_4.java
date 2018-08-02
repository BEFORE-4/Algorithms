package test.chap1.chap1_4;

public class Test1_4_4 {
    public static int count(int[] a){
     //A开始
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            //B开始
            for (int j = i + 1; j < N; j++) {
                //C开始 C为内循环
                if (a[i] + a[j] == 0)
                    //D内容
                    cnt++;
                //C结束
            }
            //B结束
        }
        return cnt;
    //A结束
    }
    /**
    语句块     运行时间      频率                      总时间
     D          t₀        x(取决于输入)              t₀x
     C          t₁        N²/2-N/2                  t₁(N²/2-N/2 )
     B          t₂          N                       t₂N
     A          t₃          1                       t₃
                        总时间                  (t₁/2)N²+(t₂-t₁N/2)N+t₃+t₀x
                        近似                  ~(t₁/2)N² (假设x很小)
                        增长的数量级                  N²
     *
     *
     */
}
