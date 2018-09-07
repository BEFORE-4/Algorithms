package test.chap1.chap1_4;

/**
 * 矩阵的局部最小值
 * 参考文档
 * https://courses.csail.mit.edu/6.006/spring11/lectures/lec02.pdf
 *
 * */
public class Test1_4_19 {
    public static void main(String[] args) {
        int[][] a = {{0, 1, 2}, {0, 1, 2}, {0, 1, 2}};
//        getMin(a, 0, 0, a.length);

    }

    /**
     * 返回局部最小值，该方法是用二分法判断每列中的最小值。复杂度为O(NlgN)
     * @param a 数组
     * @param left 数组左索引
     * @param right 数组右索引
     * @return 返回局部最小值
     */
    public static int findMin(int[][] a, int left, int right){
        int N = a.length;
        if (N == 0)
            return 0;
        if (right == -1)
            right = N;
        int j = (left + right) / 2;
        int globalMin = findGlobalMin(a, j);
        if ((globalMin - 1 > 0 && a[globalMin][j] <= a[globalMin - 1][j]) &&
                (globalMin + 1 < N && a[globalMin][j] <= a[globalMin + 1][j]) &&
                (j - 1 > 0 && a[globalMin][j] <= a[globalMin][j - 1]) &&
                (j + 1 < N && a[globalMin][j] <= a[globalMin][j + 1])){
            return a[globalMin][j];
        }else if(j > 0 && a[globalMin][j] > a[globalMin][j - 1]){
            right = j;
            return findMin(a, left, right);
        }else if (j + 1 < a[globalMin].length && a[globalMin][j] > a[globalMin][j + 1]){
            left = j;
            return findMin(a, left, right);
        }
        return a[globalMin][j];
    }
    public static int findGlobalMin(int[][] a, int column){
        int min = a[0][column];
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (min > a[i][column]){
                min = a[i][column];
                index = i;
            }
        }
        return index;
    }
}
