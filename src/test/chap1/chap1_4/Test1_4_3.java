package test.chap1.chap1_4;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;


public class Test1_4_3 {
    //测试
    public static void main(String[] args) {
        int[] n = {250, 500, 1000, 2000, 4000, 8000};
        double[] time = {0.0, 0.1, 0.1, 0.9, 5.0, 37.9};
        drawStandard(n, time);
    }

    /**
     * 画标准图，用数组n中的每个值作为x坐标，用数组time中的每个值作为y坐标
     * @param n 每次数据的数量组成的数组
     * @param time 每次数据的运行时间组成的数组
     */
    public static void drawStandard(int[] n, double[] time){
        StdDraw.setXscale(-0.5, n[n.length - 1] / 1000 + 0.5);  //水平取值范围
        StdDraw.setYscale(-5, time[time.length - 1] + 10);  //竖直取值范围
        StdDraw.line(0, 0, n[n.length - 1] / 1000, 0); //X轴
        StdDraw.line(0, 0, 0, time[time.length - 1]);   // Y轴
        //X轴刻度
        for(int i = 0; i < n[n.length - 1]/1000; i++){
            StdDraw.text(i, -3, i+"K");
        }
        //Y轴刻度
        for (int i = 0; i < time[time.length - 1] + 10; i+=10) {
            StdDraw.text(-0.2, i, i + "");
        }
        StdDraw.setPenColor(Color.red);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < n.length; i++) {
            StdDraw.point(n[i] / 1000, time[i]);
        }
    }
    public static void drawLog(int[] n,double[] time)
    {
        //将时间转换为其对数
        for(int i=0;i<time.length;i++)
            time[i]=Math.log(time[i]);
        StdDraw.setXscale(-0.5, n[n.length - 1] / 1000 + 0.5);  //水平取值范围
        StdDraw.setYscale(-3, time[time.length - 1]);  //竖直取值范围
        StdDraw.line(0, 0, n[n.length - 1] / 1000, 0); //X轴
        StdDraw.line(0, -2.5, 0, time[time.length - 1]);   // Y轴
        //X轴刻度
        for(int i = 0; i < n[n.length - 1]/1000; i++){
            StdDraw.text(i, 0, i+"K");
        }
        //Y轴刻度
        for (int i = -2; i < time[time.length - 1] + 1; i++) {
            StdDraw.text(-0.2, i, i + "");
        }
        //建立坐标系
        StdDraw.setPenColor(Color.red);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < n.length; i++) {
            StdDraw.point(n[i] / 1000, time[i]);
        }
    }
}
