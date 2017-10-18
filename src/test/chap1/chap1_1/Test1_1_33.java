package test.chap1.chap1_1;

public class Test1_1_33 {
    public static void main(String[] args) {
//        testDot();
//        testMult1();
//        testTrans();
//        testMult2();
        testMult3();
    }
//    向量点乘测试
    private static void testDot(){
        double[] x = {1, 2, 3, 4, 5, 6};
        double[] y = {7, 8, 9, 10, 11, 12};
        double result = Matrix.dot(x, y);
        System.out.println(result);
    }
//    转置矩阵测试
    private static void testTrans(){
        double[][] a = {{1,2,3,4,5},{6,7,8,9,10}};
        double[][] result = Matrix.transpose(a);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
    //    矩阵和矩阵之积测试
    private static void testMult1(){
        double[][] a = {{1, 2},{3, 4}};
        double[][] b = {{1, 2, 3, 4},{5, 6, 7, 8}};
        double[][] result = Matrix.mult(a, b);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
//    矩阵和向量之积测试
    private static void testMult2(){
        double[][] a = {{1, 2, 5, 10},{3, 4, 6, 8}};
        double[] x = {1, 2, 3, 4};
        double[] result = Matrix.mult(a, x);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
//    向量和矩阵之积测试
    private static void testMult3(){
        double[] y = {1, 2};
        double[][] a = {{1, 2, 3, 4, 5},{6, 7, 8, 9, 10}};
        double[] result = Matrix.mult(y, a);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }
}
