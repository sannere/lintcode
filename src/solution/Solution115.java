package solution;

public class Solution115 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null ||
                obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int r = 0; r < obstacleGrid.length; r++) {
            for (int c = 0; c < obstacleGrid[0].length; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                }
                else {
                    if (r - 1 >= 0) {
                        dp[r][c] += dp[r - 1][c];
                    }
                    if (c - 1 >= 0) {
                        dp[r][c] += dp[r][c - 1];
                    }
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
