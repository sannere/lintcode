package solution;

public class Solution115 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    int result;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null ||
                obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        result = 0;
        helper(obstacleGrid, 0 ,0);
        return result;
    }
    private void helper(int[][] obstacleGrid, int r, int c) {
        if (r == obstacleGrid.length && c == obstacleGrid[0].length) {
            result++;
            return;
        }
        if (obstacleGrid[r][c] == 1 ||
                r >= obstacleGrid.length || c >= obstacleGrid[0].length) {
            return;
        }
        helper(obstacleGrid, r + 1, c);
        helper(obstacleGrid, r, c + 1);
    }
}
