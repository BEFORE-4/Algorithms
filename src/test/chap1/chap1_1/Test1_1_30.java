package test.chap1.chap1_1;
//互质：两个数最大公约数为1
public class Test1_1_30 {
    public static void main(String[] args) {
        boolean[][] result = getArr(10);
        for (boolean[] item :
                result) {
            for (boolean key :
                    item) {
                System.out.print(key + "\t");
            }
            System.out.println();
        }
    }
    //在输出中，将二维数组的起始值定为1，而不是0
    private static boolean[][] getArr(int N){
        boolean[][] arr = new boolean[N][N];
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= arr[i -1].length; j++) {
                if (Euclid(i, j) == 1){
                    arr[i - 1][j - 1] = true;
                }
            }
        }
        return arr;
    }
    //求出最大公约数
    private static int Euclid(int m, int n){
        if (m % n == 0)
            return n;
        else
            return Euclid(n, m % n);
    }
}
