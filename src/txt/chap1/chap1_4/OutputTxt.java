package txt.chap1.chap1_4;

import edu.princeton.cs.algs4.StdRandom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 生成随机整数文件
 */
public class OutputTxt {
    public static void main(String[] args) {
        File file = new File("src/txtFile/1Kints.txt"); //整数文件的地址以及文件名
        try {
            PrintWriter writer = new PrintWriter(file);
            int i = 8000;   //生成整数个数
            while(i > 0){
                int index = StdRandom.uniform(-10000, 10000);   //整数在-10000到10000之间
                writer.write(index + "\t");
                i--;
                if (i % 10 == 0)
                    writer.write("\n");
            }
            writer.flush();
            writer.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
