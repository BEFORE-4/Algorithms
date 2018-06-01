package test.chap1.chap1_1;

import edu.princeton.cs.algs4.In;

public class Test1_1_34 {
    //打印出最大和最小的数  只需要两个变量记录即可
    double getMin(){
        double min = 0;
        double[] nums = In.readDoubles("txtFile/largeT.txt");
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]){
                min = nums[i];
            }
        }
        return min;
    }
//    打印出所有的中位数   需要记录所有变量
//    打印出第k小的数,k小于100  只需记录最小的100个数即可
//    打印出所有数的平方和  只需一个sum记录总和即可
//    打印出N个数的平均值  只需记录总和sum,个数n即可
//    打印出大于平均值的数的百分比 需要记录所有变量
//    将N个数按照升序打印    需要记录所有变量
//    将N个数按照随机顺序打印  需要记录所有变量
}

