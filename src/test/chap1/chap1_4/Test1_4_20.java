package test.chap1.chap1_4;

/**
 * 双调查找
 * 时间复杂度为O(logN)
 * 在二分法查找过程中，不要用递归；递归是一种很差的实现
 */
public class Test1_4_20 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 5, 4, 3, 2};
        System.out.println(getMax(a));
        boolean result = contain(10, a);
        System.out.println(result);
    }
    private static boolean contain(int N, int[] arr){
        int index = getMax(arr);    //最大数索引,logN
        boolean r = containLeft(N, arr, index);  //左部分是否包含 logN
        if (r)  //包含，直接结束
            return true;
        return containRight(N, arr, index); //右部分是否包含  logN
    }
    private static int getMax(int[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < arr[mid - 1]){
                hi = mid - 1;
            }else if (arr[mid] < arr[mid + 1]){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return hi;
    }
    private static boolean containLeft(int N, int[] arr, int right){
        int left = 0;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] < N){
                left = mid + 1;     //中间数的右边取为界限
            }else if (arr[mid] > N){
                right = mid - 1;    //中间数的左边取为界限
            }else {
                return true;
            }
        }
        return false;
    }
    private static boolean containRight(int N, int[] arr, int left){
        int right =  arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] < N){
                right = mid - 1;    //中间数的左边取为界限
            }else if (arr[mid] > N){
                left = mid + 1;     //中间数的右边取为界限
            }else {
                return true;
            }
        }
        return false;
    }
}
