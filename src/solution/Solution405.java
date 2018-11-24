package solution;

import java.util.HashMap;
import java.util.Map;

public class Solution405 {
    /*
     * @param matrix: an integer matrix
     * @return: the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }

        int[][] prefixSum = new int[matrix.length + 1][matrix[0].length + 1];
        getprefixSum(matrix, prefixSum);
        for (int row1 = 0; row1 < matrix.length; row1++) {
            for (int row2 = row1 + 1; row2 <= matrix.length; row2++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int col2 = 0; col2 <= matrix[0].length; col2++) {
                    int diff = prefixSum[row2][col2] - prefixSum[row1][col2];
                    if (map.containsKey(diff)) {
                        int col1 = map.get(diff);
                        int[][] coordinates = new int[2][2];
                        coordinates[0][0] = row1 ;
                        coordinates[0][1] = col1;
                        coordinates[1][0] = row2 - 1;
                        coordinates[1][1] = col2 - 1;
                        return coordinates;
                    }
                    else {
                        map.put(diff, col2);
                    }
                }
            }
        }

        return new int[0][0];
    }
    private void getprefixSum(int[][] matrix, int[][] prefixSum) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                prefixSum[r + 1][c + 1] = prefixSum[r][c + 1] + prefixSum[r + 1][c] +
                        matrix[r][c] - prefixSum[r][c];
            }
        }
    }
}
