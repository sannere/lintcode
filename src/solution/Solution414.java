package solution;



public class Solution414 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        // Note: 在这里必须先取long再abs，否则int的最小值abs后也是原值
        long result = 0, dividendLong = Math.abs((long) dividend), divisorLong = Math.abs((long) divisor);

        while (dividendLong >= divisorLong) {
            int shift = 0;
            while (dividendLong >= divisorLong << shift) {//每shift一次，divisorLong就乘一个2.
                shift++;
            }
            shift--;//因为dividendLong >= divisorLong * 2^0，所以shift最小为1，shift--后不会为负数
            result += 1 << shift;
            dividendLong -= divisorLong << shift;
        }
        if (result >= Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            return (int) -result;
        }
        return (int) result;
    }

}
