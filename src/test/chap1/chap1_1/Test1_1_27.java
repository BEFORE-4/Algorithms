package test.chap1.chap1_1;

public class Test1_1_27 {
    public static double binomial(int N, int k, double p){
        if (N == 0 && k == 0)
            return 1.0;
        if (N < 0 || k < 0)
            return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N-1, k-1, p);
    }
    public static double binomial2(int N, int k, double p, double[][] temp){
        if (N == 0 && k == 0){
            temp[N][k] = 1.0;
            return 1.0;
        }
        for (int i = 1; i < N + 1; i++) {
            temp[i][0] = temp[i - 1][0] * (1 - p);
        }
        for (int i = 0; i < N + 1; i++) {
            for (int j = 1; j <= i && j < k + 1 ; j++) {
                temp[i][j] = (1 - p) * temp[i - 1][j] + p * temp[i - 1][j - 1];
            }
        }
        return temp[N][k];
    }
}
