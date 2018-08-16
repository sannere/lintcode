package solution;

public class Solution428_2 {
    public double myPow(double x, int n) {
        if (x == 0 || n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < -10000) {
            return 0;
        }
        int abs = Math.abs(n);
        double temp = myPow(x, abs / 2);

        if (abs / 2 + 1== (abs + 1) / 2) {
            temp =  temp * (temp * x);
        }
        else {
            temp = temp * temp;
        }
        if (n > 1) {
            return temp;
        }
        else {
            return 1 / temp;
        }
    }

}