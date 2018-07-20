package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class Test1_3_43 {
    public static void main(String[] args) {
        String dirName = args[0];
        Queue<String> q = getNames(dirName);
        for (String str :
                q) {
            StdOut.println(str);
        }
    }

    private static Queue<String> getNames(String fileName){
        Queue<String> q = new Queue<>();
        File file = new File(fileName);
        q.enqueue(file.getName());  //得到名字存进队列中
        Queue<String> childs;
        //如果是目录，进行递归
        if (file.isDirectory()){
            String[] strs = file.list();
            if(strs == null)
                return q;
            for (String f : strs) {
                childs = getNames(file.getPath() + File.separator + f);
                for (String str:childs) {
                    q.enqueue("\t" + str);
                }
            }
        }
        return q;
    }
}
