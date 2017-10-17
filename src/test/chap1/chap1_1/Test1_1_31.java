package test.chap1.chap1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Test1_1_31 {
    //  命令行  10 0.5   两个参数分别代表整数N,概率p
    public static void main(String[] args) {
        double x = 60, y = 60, r = 60;  //x坐标,y坐标, 半径
        int N = Integer.valueOf(args[0]);
        double p = Double.valueOf(args[1]);
        drawCircle(x, y, r);    //画圆
        double[][] points = getPoints(x, y, r, N);  //得到点坐标
        drawPoints(points); //画点
        drawLine(points, p);    //连线
    }

    /**
     * 画圆
     * @param x x坐标
     * @param y y坐标
     * @param r 半径
     */
    private static void drawCircle(double x, double y, double r){
        StdDraw.setXscale(-10, 130);
        StdDraw.setYscale(-10, 130);
        StdDraw.circle(x, y, r);
    }

    /**
     * 得到圆上的N个点
     * @param x
     * @param y
     * @param r
     * @param N
     * @return
     */
    private static double[][] getPoints(double x, double y, double r, int N){
        double[][] points = new double[N][2];
        double angle = Math.toRadians(360 / N);
        double start = 0.0;
        for (int i = 0; i < N; i++) {
            double x0 = x + r * Math.cos(start);
            double y0 = y + r * Math.sin(start);
            points[i][0] = x0;
            points[i][1] = y0;
            start += angle;
        }
        return points;
    }

    /**
     * 画点
     * @param points
     */
    private static void drawPoints(double[][] points){
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setXscale(-10, 130);
        StdDraw.setYscale(-10, 130);
        for (int i = 0; i < points.length; i++) {
            StdDraw.point(points[i][0],points[i][1]);
        }
    }

    /**
     * 连线
     * @param points
     */
    private static void drawLine(double[][] points, double p){
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (StdRandom.uniform(0.0, 1.0 ) <= p){
                    StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]);
                }
            }
        }
    }
}
