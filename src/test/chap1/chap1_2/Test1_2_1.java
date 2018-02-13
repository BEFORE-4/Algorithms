package test.chap1.chap1_2;

import edu.princeton.cs.algs4.Point2D;

public class Test1_2_1 {
//    正整数参数为画的点个数
//    java Test1_2_1 100
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            double x = Math.random();
            double y = Math.random();
            points[i] = new Point2D(x, y);
            points[i].draw();
        }
        Point2D p1 = points[0], p2 = points[0];
        double min = 1.0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = points[i].distanceTo(points[j]);
                if (distance < min){
                    min = distance;
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }
        System.out.println(min);
        p1.drawTo(p2);
    }
}
