package solution;

public class Solution428 {
    public double myPow(double x, int n) {
        if (x == 0 || n == 0) {
            return 1;
        }

        double[] p = new double[Math.abs(n) + 1];

        if (n > 0) {
            return getPow(x, n, p);
        }
        return 1 / getPow(x, Math.abs(n), p);
    }

    private double getPow(double x, int n, double[] p) {
        if (n == 1) {
            return x;
        }
        p[n / 2] = getPow(x, n / 2, p);
        if ((n + 1) / 2 == (n / 2) + 1) {
            p[(n / 2) + 1] = p[n / 2] * x;
        }

        p[n] = p[n / 2] * p[(n + 1) / 2];

        return p[n];
    }
}
