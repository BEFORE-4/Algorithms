package test.chap1.chap1_3;


import txt.chap1.chap1_3.Queue;

import java.util.Scanner;

//输入  2/29/2018|3/19/2013   日期用|分隔
public class Test1_3_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String info = scanner.next();
        SmartDate[] date = readDates(info);
        for (int i = 0; i < date.length; i++) {
            System.out.println(date[i]);
        }
    }
    public static SmartDate[] readDates(String name){
        String[] info = name.split("\\|");
        Queue<String> q = new Queue<>();
        for (String str :
                info) {
            q.enqueue(str);
        }
        int N = q.size();
        SmartDate[] date = new SmartDate[N];
        for (int i = 0; i < N; i++) {
            date[i] = new SmartDate(q.dequeue());
        }
        return date;
    }
}
class SmartDate{
    private long time;
    private int year;   //距离2000年一共几年
    private int month;
    private int day;

    SmartDate(int month, int day, int year){
        this(concact(month, day, year));
    }
    //month和day如果小于10，需要前面加 0
    private static String concact(int month, int day, int year){
        String date = String.valueOf(year);
        if (month < 10){
            date += "0" + month;
        }else{
            date += month;
        }
        if (day < 10){
            date += "0" + day;
        }else{
            date += day;
        }
        return date;
    }
    SmartDate(String s){
        this(concact(s));
    }
    private static int concact(String s){
        int a;
        String[] result = s.split("/");
        a = Integer.valueOf(result[2]);
        a = Integer.valueOf(result[0]) + a * 100;
        a = Integer.valueOf(result[1]) + a * 100;
        return a;
    }
    SmartDate(int a){
        int day = a % 100;
        int month = a / 100 % 100;
        int year = a / 100 / 100;
        setYear(year - 2000);
        setMonth(month);
        setDay(day);
        //月份在1到2月之间
        if (month > 12 || month == 0){
            throw new IllegalArgumentException();
        }
        //需要根据闰年，判断每个月多少天，此处假设都是31天
        if (day > 31){
            throw new IllegalArgumentException();
        }
        System.out.println(year + "年" + month + "月" +  day + "日");
    }

    /**
     *
     * @param n 和2000年1月1号之间的天数
     * @return  该天是星期几
     */
    String dayOfTheWeek(int n){
        n = n % 7;
        switch (n){
            case 2 :
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 0:
                return "Saturday";
            case 1:
                return "Sunday";
        }
        return null;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public int getYear() {
        return year;
    }

    private  void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    private  void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    private  void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "SmartDate{" +
                "time=" + time +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}