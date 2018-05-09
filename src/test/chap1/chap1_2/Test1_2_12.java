package test.chap1.chap1_2;

import edu.princeton.cs.algs4.Transaction;

public class Test1_2_12 {
    public static void main(String[] args) {
        SmartDate date = new SmartDate("20000101");
        //假设每年365天，每月31天。算出距离2000年1月1日的天数
        int days = date.getYear() * 365 + (date.getMonth() - 1) * 31 + date.getDay() - 1;
        String week = date.dayOfTheWeek(days);
        System.out.println(week);
    }
}
