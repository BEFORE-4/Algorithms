package test.chap1.chap1_1;

public class Matrix {
    // 向量点乘
    //  a•b = a₁b₁ + a₂b₂ + a₃b₃ + ...
    // x 和 y 长度需相等
    static double dot(double[] x, double[] y){
        double result = 0.0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }
//    矩阵和矩阵之积
//    a数组需要为2行*2列   b数组需要为2*x列
     static double[][] mult(double[][] a, double[][] b){
        double[][] result = new double[2][b[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < b.length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
//    转置矩阵
//    二维数组长度一致
     static double[][] transpose(double[][] a){
        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[j][i] = a[i][j];
            }
        }
        return result;
    }
//    矩阵和向量之积
//    a数组需要为2行*n列 x数组长度位n,看作n行*1列 返回2行*1列结果作为一维数组
    // 若将x看作1*n,返回结果为多维数组,不是double[]
     static double[] mult(double[][] a, double[] x){
        double[] result = new double[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
            for (int j = 0; j < x.length; j++) {
                result[i] += a[i][j] * x[j];
            }
        }
        return result;
    }
//    向量和矩阵之积
//    y数组为1行*2列,a数组为2行*n列 返回1行*n列结果作为一维数组
     static double[] mult(double[] y, double[][] a){
        double[] result = new double[a[0].length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
            for (int j = 0; j < y.length; j++) {
                result[i] += y[j] * a[j][i];
            }
        }
        return result;
    }
}
