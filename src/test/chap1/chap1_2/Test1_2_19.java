package test.chap1.chap1_2;

public class Test1_2_19 {
    public static void main(String[] args) {
        //Date字符串解析
        SmartDate date = new SmartDate("05/22/2018");
        System.out.println(date);
        //Transaction字符串解析
        Transaction transaction = new Transaction("tom 05/22/2018 23");
        System.out.println(transaction);
    }
}
