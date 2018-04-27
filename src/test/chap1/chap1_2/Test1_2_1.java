package test.chap1.chap1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;


public class Test1_2_1 {
    //命令行参数为 100
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] points = getPoints(N);
        double minDistance = 2;   //两个点的最远距离是√2, 取大于√2作为初始值
        double temp;  //循环中两个点的距离
        for (Point2D p:
             points) {
            for (Point2D q :
                    points) {
                temp = p.distanceTo(q);
                System.out.println(temp);
                //距离为0排除
                if (temp != 0 && temp < minDistance){
                    minDistance = temp;     //两点距离比最小值小,则更换最小值
                }
            }
        }
        System.out.println(minDistance);
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
