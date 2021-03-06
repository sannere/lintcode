package solution;

public class Solution140 {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {

        //(a1+a2)^n % b = a1^n % b + a2^n % b
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }


        long temp = fastPower(a, b, n / 2);
        temp = (temp * temp) % b;
        if (n % 2 != 0) {
            temp = (temp * a % b) %b;
        }
        return (int)temp;

    }
}
