package test.chap1.chap1_2;

public class Rational {
    private long numerator;
    private long denominator;

    Rational(long numerator, long denominator) {
        long index = gcd(numerator, denominator);
        this.numerator = numerator / index;
        this.denominator = denominator / index;

    }

    /**
     * @param b 另一个有理数
     * @return 该数与b之和
     */
    Rational plus(Rational b) {
        long newDenominator = denominator * b.getDenominator();  //通分
        long newNumeraotr = numerator * b.getDenominator() + denominator * b.getNumerator();
        //防止溢出断言
        if (numerator > 0 && b.getNumerator() > 0)
            assert newNumeraotr > 0 : "数据溢出";
        Rational result = new Rational(newNumeraotr, newDenominator);
        simplify(result);
        return result;
    }

    /**
     * @param b 另一个有理数
     * @return 该数与b之差
     */
    Rational minus(Rational b) {
        long newDenominator = denominator * b.getDenominator();  //通分
        long newNumerator = numerator * b.getDenominator() - denominator * b.getNumerator();
        Rational result = new Rational(newNumerator, newDenominator);
        simplify(result);
        return result;
    }

    /**
     * @param b 另一个有理数
     * @return 该数与b之积
     */
    Rational times(Rational b) {
        long newDenominator = denominator * b.getDenominator();
        long newNumeraotr = numerator * b.getNumerator();
        Rational result = new Rational(newNumeraotr, newDenominator);
        simplify(result);
        return result;
    }

    /**
     * @param b 另一个有理数，除数
     * @return 该数与b之商
     */
    Rational divides(Rational b) {
        long newDenominator = denominator * b.getNumerator();
        long newNumeraotr = numerator * b.getDenominator();
        Rational result = new Rational(newNumeraotr, newDenominator);
        simplify(result);
        return result;
    }

    /**
     * 两数是否相等
     *
     * @param that 比较的数
     * @return 相等返回true，否则返回false
     */
    boolean equals(Rational that) {
        if (this.denominator == that.getDenominator()) {
            return this.numerator == that.getNumerator();   //分母和分子都相等返回true
        } else {
            Rational result = this.minus(that);
            return result.getNumerator() == 0;  //相减后分子为0，返回true
        }
    }

    @Override
    public String toString() {
        return getNumerator() == 0 ? "0" : (getNumerator() + "/" + getDenominator());
    }

    private long getNumerator() {
        return numerator;
    }

    private void setNumerator(long numerator) {
        this.numerator = numerator;
    }

    private long getDenominator() {
        return denominator;
    }

    private void setDenominator(long denominator) {
        this.denominator = denominator;
    }

    private long gcd(long a, long b) {
        //始终让a最大
        if (a < b) {
            a += b;
            b = a - b;
            a = a - b;
        }
        if (b == 0)
            return 1;
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }

    /**
     * 约分
     *
     * @param that 约分的分数
     */
    private void simplify(Rational that) {
        long index = gcd(that.getNumerator(), that.getDenominator());
        that.setDenominator(that.getDenominator() / index);
        that.setNumerator(that.getNumerator() / index);
    }
}
