package test.chap1.chap1_2;


public class Accumulator {
    private int n = 0;          // number of data values
    private double sum = 0.0;   // sample variance * (n-1)
    private double mu = 0.0;    // sample mean

    /**
     * Initializes an accumulator.
     */
    public Accumulator() {
    }

    /**
     * Adds the specified data value to the accumulator.
     * @param  x the data value
     */
    public void addDataValue(double x) {
        n++;
        double delta = x - mu;
        mu  += delta / n;
        sum += (double) (n - 1) / n * delta * delta;
    }

    /**
     * Returns the mean of the data values.
     * @return the mean of the data values
     */
    public double mean() {
        return mu;
    }

    /**
     * Returns the sample variance of the data values.
     * @return the sample variance of the data values
     */
    public double var() {
        if (n <= 1) return Double.NaN;
        return sum / (n - 1);
    }

    /**
     * Returns the sample standard deviation of the data values.
     * @return the sample standard deviation of the data values
     */
    public double stddev() {
        return Math.sqrt(this.var());
    }

    /**
     * Returns the number of data values.
     * @return the number of data values
     */
    public int count() {
        return n;
    }

    /**
     * Returns a string representation of this accumulator.
     * @return a string representation of this accumulator
     */
    public String toString() {
        return "n = " + n + ", mean = " + mean() + ", stddev = " + stddev();
    }


}
