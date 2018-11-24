package solution;

public class Solution114 {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r > 0) {
                    dp[r][c] += dp[r - 1][c];
                }
                if (c > 0) {
                    dp[r][c] += dp[r][c - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
