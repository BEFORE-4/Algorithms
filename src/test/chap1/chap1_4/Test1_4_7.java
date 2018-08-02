package test.chap1.chap1_4;

public class Test1_4_7 {
    public static int count(int[] a){
        //A开始
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            //B开始
            for (int j = i + 1; j < N; j++) {
                //C开始
                for (int k = j + 1; k < N; k++) {
                    //D开始
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;  //满足比较，E执行
                    //D结束
                }
                //C结束
            }
            //B结束
        }
        return cnt;
        //A结束
    }
    /**
     语句块     运行时间      频率                      总时间
     D          t₀        N³/6-N²/2+N/3              t₀(N³/6-N²/2+N/3)
     C          t₁        N²/2-N/2                  t₁(N²/2-N/2 )
     B          t₂          N                       t₂N
     A          t₃          1                       t₃
     总时间                  (t₁/2)N²+(t₂-t₁N/2)N+t₃+t₀(N³/6-N²/2+N/3)
     近似                  ~(t₀/6)N³
     增长的数量级                  N³
     *
     *
     */
}
