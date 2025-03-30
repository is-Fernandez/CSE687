package edu.syr.hw5;

public class Rational1 {
    private int numer;
    private int denom;
    private int g;

    private static final int cachesize = 20;
    private static Rational1[] cache = new Rational1[cachesize];
    private static int cacheIndex = 0;

    // Private constructor to ensure no external creation of Rational instances
    private Rational1(int n, int d) {
        if (d == 0) {
            throw new IllegalArgumentException("Denominator can't be 0!");
        }
        g = gcd(n, d); // Compute GCD
        numer = n / g; // Simplify numerator
        denom = d / g; // Simplify denominator
    }

    public static Rational1 getInstance(int n, int d) {
        for (Rational1 r : cache) {
            if (r != null && r.numer == n && r.denom == d) {
                return r;
            }
        }
        Rational1 rational = new Rational1(n, d);
        cache[cacheIndex] = rational;
        cacheIndex = (cacheIndex + 1) % cachesize;
        return rational;
    }
    public static Rational1 getInstance(int n) {
        return getInstance(n, 1); // Delegate to the two-parameter method
    }


    private static int gcd(int n, int d) {
        return d==0 ? n : gcd(d, n%d);
    }

    @Override
    public String toString() {
        return denom == 1 ? numer + "" : numer + "/" + denom;
    }

    public Rational1 add(Rational1 that) {
        return getInstance(numer * that.denom + denom * that.numer, denom * that.denom);
    }

    public Rational1 add(int that) {
        return add(getInstance(that));
    }

    public boolean lessThan(Rational1 that) {
        return this.numer * that.denom < that.numer * this.denom;
    }

    public boolean lessThan(int that) {
        return lessThan(getInstance(that));
    }

    public Rational1 max(Rational1 that) {
        return this.lessThan(that) ? that : this;
    }

    public Rational1 max(int that) {
        return max(getInstance(that));
    }

    public static void main(String[] args) {
        Rational1 half = getInstance(1, 2);
        Rational1 third = getInstance(1, 3);
        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational1 result = half.add(third);
        Rational1 fiveSixths = getInstance(5, 6);
        System.out.println("are they the same object? " + (result == fiveSixths)); // Should be true if cached correctly
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false
        Rational1 one = getInstance(1);  // Corrected usage of getInstance
        Rational1 oneAndHalf = one.add(half);
        System.out.println(oneAndHalf); // prints "3/2";

        Rational1 fifteenOverTen = getInstance(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"
    }
}