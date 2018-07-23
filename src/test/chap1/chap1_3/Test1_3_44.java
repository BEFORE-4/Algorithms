package test.chap1.chap1_3;

public class Test1_3_44 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.insert('d');
        buffer.insert('e');
        buffer.insert('f');
        buffer.delete();
        buffer.left(1);
        buffer.left(2);
        //光标多次右移，检验结果
        buffer.right(1);
        buffer.right(1);
        buffer.right(1);
    }
}
