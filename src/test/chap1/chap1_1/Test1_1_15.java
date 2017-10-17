package test.chap1.chap1_1;

public class Test1_1_15 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6};
        int[] result = histogram(arr, 8);
        System.out.println();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
    public static int[] histogram(int[] a, int M){
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i){
                    result[i]++;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }
        System.out.println(sum);
        return result;
    }
}
