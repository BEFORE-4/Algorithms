package test.chap1.chap1_1;

public class Test1_1_22 {
    public static void main(String[] args) {
        int[] a = {1,3,23,34,35,45,56,67,69,76,83,93,95,98};
        System.out.println("begin=======");
        int result = rank(46, a);
        System.out.println();
        System.out.println(result);
    }
    public static int rank(int key, int[] a){
        return rank(key, a, 0, a.length - 1, 0);
    }
    public static int rank(int key, int[] a, int lo, int hi, int depth){
        System.out.print("depth: " + depth);
        System.out.print("\tlo: " + lo);
        System.out.print("\thi: " + hi);

        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        System.out.print("\tmid: " + a[mid] );
        System.out.println();
        if (key < a[mid])
            return rank(key, a, lo, mid - 1, ++depth);
        else if (key > a[mid])
            return rank(key, a, mid + 1, hi, ++depth);
        else
            return mid;
    }
}
