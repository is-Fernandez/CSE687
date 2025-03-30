package edu.syr.hw4;
import java.io.*;

/* Adapted from Programming in Scala, Odersky */

public class Rational {
    private int numer;
    private int denom;
    private int g;
    public Rational(int n, int d) { /*implement this*/
        if (d == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        g = gcd(n, d);
        numer = n/g;
        denom = d/g;
    }

    public Rational(int n) {/*implement this*/
    numer = n;
    denom = 1;
    g = 1;
    }
    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }
    public int getNumerator() {
        return numer;
    }

    public int getDenominator() {
        return denom;
    }

    @Override
    public String toString() {/*implement this*/
    return numer + "/" + denom;}

    public Rational add(Rational that) {/*implement this*/
        int newNumer = this.numer * that.denom + that.numer * this.denom;
        int newDenom = this.denom * that.denom;
        return new Rational(newNumer, newDenom);}

    public Rational add(int that) {/*implement this*/
        return this.add(new Rational(that));}

    public boolean lessThan(Rational that) {
        return this.numer * that.denom < that.numer * this.denom;
    }

    public boolean lessThan(int that) {
        return this.numer < that * this.denom;
    }

    public Rational max(Rational that) {
        return this.lessThan(that) ? that : this;
    }

    public Rational max(int that) {
        return this.lessThan(that) ? new Rational(that, 1) : this;
    }

    public static void main(String[] args) {
        Rational half = new Rational(1, 2);
        Rational third = new Rational(1, 3);
        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational result = half.add(third);
        Rational fiveSixths = new Rational(5, 6);
        System.out.println("are they the same object? " + (result == fiveSixths));
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false
        Rational one = new Rational(1);
        Rational oneAndHalf = one.add(half);
        System.out.println(oneAndHalf); // prints "3/2";
        Rational fifteenOverTen = new Rational(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"
    }
}

