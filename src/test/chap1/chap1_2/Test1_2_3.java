package test.chap1.chap1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

public class Test1_2_3 {
//    正整数参数为正方形对数量,假设4个正方形
// 两个正方形有相交，相交数加1  两个正方形有包含，包含数加1  包含属于相交
//    java Test1_2_3 4 0 0.99
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        Interval2D[] intervals = getInterVal(N, min, max);
        for (Interval2D inter:
             intervals) {
            inter.draw();
        }
        int intersectNum = 0, containNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])){
                    intersectNum++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                Point2D[] ps = getPoint(intervals[j]);
                if (intervals[i].contains(ps[0]) &&
                        intervals[i].contains(ps[1])){
                    containNum++;
                }
            }
        }
        System.out.println("相交数量 ：" + intersectNum);
        System.out.println("包含数量 ：" + containNum);
    }

    /**
     * 通过参数创建矩形
     * @param N 创建数量
     * @param d1   矩形长宽在d1和d2之间
     * @param d2
     * @return  返回创建的矩形
     */
    private static Interval2D[] getInterVal(int N, double d1, double d2){
        Interval2D[] result = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            double start = StdRandom.uniform(d1, d2);
            double end = StdRandom.uniform(d1, d2);
            Interval1D line1 = getLine(start, end);
            Interval1D line2 = getLine(start, end);
            result[i] = new Interval2D(line1, line2);
        }
        return result;
    }

    /**
     * 通过参数创建一条线
     * @param point1
     * @param point2
     * @return
     */
    private static Interval1D getLine(double point1, double point2){
        if(point1 > point2){
            point1 = point1 + point2;
            point2 = point1 - point2;
            point1 = point1 - point2;
        }
        Interval1D result = new Interval1D(point1, point2);
        return result;
    }

    /**
     * 得到矩形左下角和右上角点的坐标
     * @param box
     * @return  返回矩形两点坐标
     */
    private static Point2D[] getPoint(Interval2D box){
        Point2D[] result = new Point2D[2];
        String boxStr = box.toString();
        String[] line = boxStr.split("x");
        double[] num = new double[4];
        int index = 0;
        System.out.println(box);
        for (int i = 0; i < line.length; i++) {
            String str1 = line[i].trim().substring(1, line[i].trim().indexOf(","));
            String str2 = line[i].trim().substring(line[i].trim().indexOf(",") + 2, line[i].trim().indexOf("]"));
            num[index++] = Double.parseDouble(str1);
            num[index++] = Double.parseDouble(str2);
        }
        result[0] = new Point2D(num[0], num[2]);
        result[1] = new Point2D(num[1], num[3]);
        System.out.println(result[0]);
        System.out.println(result[1]);
        return result;
    }
}
