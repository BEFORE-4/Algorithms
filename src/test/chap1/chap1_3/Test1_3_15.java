package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;
import txt.chap1.chap1_3.Queue;

import java.util.Scanner;

/**
 * 接收命令行的一个参数k，打印倒数第k个字符
 */
public class Test1_3_15 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        Queue<String> queue = new Queue<>();
        //输入stop跳出循环
        while (!scanner.hasNext("stop")){
            queue.enqueue(scanner.next());
        }
        scanner.close();
        int size = queue.size();    //queue的size会变，所以先取到size值的大小
        for (int i = 0; i < size - k; i++){
            queue.dequeue();
        }
        StdOut.println(queue.dequeue());
    }
}
