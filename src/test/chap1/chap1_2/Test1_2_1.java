package test.chap1.chap1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

public class Test1_2_1 {
//    正整数参数为画的点个数
//    java Test1_2_1 100
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] points = getPoints(N);
        double minDistance = 2;   //两个点的最远距离是√2, 取大于√2作为初始值
        Point2D p1 = points[0], p2 = points[0];
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = points[i].distanceTo(points[j]);
                if (distance < minDistance){
                    minDistance = distance;
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }
        System.out.println(minDistance);
        p1.drawTo(p2);
    }
    /**
     * 根据参数得到点组成的数组 点的两个坐标取值范围为[0, 1)
     * @param N 点数量
     * @return  返回数组
     */
    private static Point2D[] getPoints(int N){
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
        }
        return points;
    }
}
