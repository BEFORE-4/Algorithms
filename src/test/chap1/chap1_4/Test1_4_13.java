package test.chap1.chap1_4;

public class Test1_4_13 {
    /**
     Accumulator
     一个int，一个double
     16字节对象开销，4字节int，8字节double,外加4个填充字节
     合计32字节
     */
    /**
     Transaction
     一个String，一个double，一个Date
     16字节对象开销，8字节String对象引用，8字节一个double，外加一个Date需要32字节
     Date中是16字节对象开销，12字节三个int，外加4个填充字节，合计32字节
     String中40字节String本身，24+2N 字节为String中字符数组的开销。String合计64+2N
     该对象合计128+2N字节
     */
    /**
     FixedCapacityStackOfStrings 其容量为C且含有N个元素
     一个int，一个String[]数组
     16字节对象开销，4字节int，8字节数组引用，4字节填充字节
     String[]数组需要，24字节数组开销，8C字节String引用开销
     一个String对象需要字节 64+2M (M为String字符串长度)
     N个元素需要字节为   (64+2M)N
     总和： 16+4+8+4+24+8C+(64+2M)N
     该对象合计56+8C+(64+2M)N
     */

    /**
     Point2D
     两个double
     16字节对象开销，16字节两个double，
     合计32字节
     */

    /**
     Interval1D
     两个double
     16字节对象开销，16字节两个double，
     合计32字节
     */
    /**
     Interval2D
     两个Interval1D
     16字节对象开销，16字节两个Interval1D引用开销。两个Interval1D需要64字节
     合计96字节
     */

    /**
     Double
     16字节对象开销，8字节double
     合计24字节
     */
}
