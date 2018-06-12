package test.chap1.chap1_3;

import txt.chap1.chap1_3.Queue;

import java.util.Scanner;

/**
 * Turing|5/22/1939|11.99^Turing|6/12/1939|311.99
 * 每个之间用^隔开。
 * 字符之间的空格用|代替
 */
public class Test1_3_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String info = scanner.next();
        Transaction[] date = readDates(info);
        for (int i = 0; i < date.length; i++) {
            System.out.println(date[i]);
        }
    }

    public static Transaction[] readDates(String name) {
        String[] info = name.split("\\^");
        Queue<String> q = new Queue<>();
        for (String str :
                info) {
            q.enqueue(str.split("\\|")[0] + " " +
                    str.split("\\|")[1] + " " +
                    str.split("\\|")[2]);
        }
        int N = q.size();
        Transaction[] date = new Transaction[N];
        for (int i = 0; i < N; i++) {
            date[i] = new Transaction(q.dequeue());
        }
        return date;
    }
}

class Transaction implements Comparable<Transaction> {
    private final String who;      // customer
    private final SmartDate when;     // date
    private final double amount;   // amount

    public Transaction(String who, SmartDate when, double amount) {
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        String[] a = transaction.split("\\s+");
        who = a[0];
        when = new SmartDate(a[1]);
        amount = Double.parseDouble(a[2]);
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
    }

    public String who() {
        return who;
    }

    public SmartDate when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%-10s %10s %8.2f", who, when, amount);
    }

    public int compareTo(Transaction that) {
        return Double.compare(this.amount, that.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (who != null ? !who.equals(that.who) : that.who != null) return false;
        return when != null ? when.equals(that.when) : that.when == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = who != null ? who.hashCode() : 0;
        result = 31 * result + (when != null ? when.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}