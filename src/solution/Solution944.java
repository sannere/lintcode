package solution;

import java.util.HashMap;
import java.util.Map;

public class Solution944 {
    /**
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
    public int maxSubmatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int[][] prefixSum = new int[n + 1][n];
        int max = matrix[0][0];

        //get prefixSum
        for (int i = 0; i < n; i++) {
            prefixSum[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i + 1][j] = prefixSum[i][j] + matrix[i][j];
            }
        }

        //遍历prifixsum得到一维sumArray
        for (int up = 0; up < n + 1; up++) {
            for (int down = up + 1; down < n + 1; down++) {
                int[] sumArr = new int[n];
                for (int col = 0; col < n; col++) {
                    sumArr[col] = prefixSum[down][col] - prefixSum[up][col];
                }
                //在sumArray中找最大
                int sum = 0;
                for (int num : sumArr) {
                    sum += num;
                    max = Math.max(sum, max);
                    sum = Math.max(sum, 0);
                }
            }
        }

        return max;
    }
}
