package test.chap1.chap1_4;

public class Test1_4_6 {
    int N = 1000;

    /**
     1  1   1
     2  2   3
     3  3   4
     4  4   7
     5  5   8
     6  6   10
     7  7   11
     8  8   15
     9  9   16
     10 10  18
     11 11  19
     12 12  22
     13 13  23
     14 14  25
     15 15  26
     16 16  31
     17 17  32
     18 18  34
     19 19  35
     20 20  38
     21 21  39
     22 22  41
     23 23  42
     24 24  46
     25 25  47
     *
     */
//变化为2N，增长数量级为2N
    void a(){
        int sum = 0;
        for (int n = N; n > 0 ; n /= 2) 
            for (int i = 0; i < n; i++)
                sum++;
    }
    /**
     1      1       1
     3      2       3
     5      4       7
     9      8       15
     17     16      31
     33     32      63
     65     64      127
     129    128     255
     257    256     511
     513    512     1023
     1025   1024    2047
     2049   2048    4095
     4097   4096    8191
     *
     */
    //变化为2N，增长数量级为2N
    void b(){
        int sum = 0;
        for (int i = 1; i < N; i *= 2)
            for (int j = 0; j < i; j++)
                sum++;
    }
    //NlogN
    void c(){
        int sum = 0;
        for (int i = 1; i < N; i *= 2)
            for (int j = 0; j < N; j++)
                sum++;
    }
}
