package test.chap1.chap1_2;

public class Test1_2_6 {
    public static void main(String[] args) {
        String s = "ACTGAC";
        String t = "TGACGA";
        if (judge(s, t))
            System.out.println("回环");
        else
            System.out.println("不是回环");
    }
    private static boolean judge(String s, String t){
        if (s.length() != t.length())
            return false;
        s += s;
        int index = s.indexOf(t);
        if (index == -1)        //没有找到，则不是回环
            return false;
        String start = s.substring(0, index);   //截取后的左边位置
        String end = s.substring(index + t.length());   //截取后的右边字符串
        end += start;           //将右边和左边拼接后还是一个t字符串
        return end.equals(t);   //截取的字符串相等则是回环。
    }
}
