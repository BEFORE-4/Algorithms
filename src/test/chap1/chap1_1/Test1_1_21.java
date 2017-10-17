package test.chap1.chap1_1;

import java.util.Scanner;

public class Test1_1_21 {
    public static void main(String[] args) {
        Object[][] obj = getInfos();
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i][0] + "\t" + obj[i][1] + "\t" + obj[i][2] +"\t" + obj[i][3]);
        }
    }
    public static Object[][] getInfos(){
        Object[][] obj = new Object[4][4];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < obj.length; i++) {
            obj[i][0] = scanner.next();
            obj[i][1] = scanner.nextInt();
            obj[i][2] = scanner.nextInt();
            obj[i][3] = String.format("%.3f", 1.0 * (int)obj[i][1] / (int)obj[i][2]);
            System.out.println("please input next data!");
        }
        return obj;
    }
}
