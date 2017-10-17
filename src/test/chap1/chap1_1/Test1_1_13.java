package test.chap1.chap1_1;

public class Test1_1_13 {
    private static final int M = 3;
    private static final int N = 4;

    public static void main(String[] args) {
        int[][] arr = new int[M][N];
        int[][] transArr = new int[N][M];
        for (int i = 0; i < transArr.length; i++) {
            for (int j = 0; j < transArr[i].length; j++) {
                transArr[i][j] = arr[j][i];
            }
        }
        for (int i = 0; i < transArr.length; i++) {
            for (int j = 0; j < transArr[i].length; j++) {
                System.out.print(transArr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
