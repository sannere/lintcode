package solution;

public class Solution111 {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        helper(dp,2);
        return dp[n - 1];
    }
    private void helper(int[] dp, int index) {
        if (index == dp.length) {
            return;
        }
        dp[index] = dp[index - 1] + dp[index - 2];
        helper(dp, index + 1);
    }
}
