package test.chap1.chap1_1;

import java.util.Scanner;

public class Test1_1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (a == b && b == c){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }
}
