package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution654 {
    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        //A : m * n;   B: n * k
        int m =  A.length, n = A[0].length, k = B[0].length;
        int[][] result = new int[m][k];

        List<Integer>[] listA = new ArrayList[m];

        for (int row = 0; row < m; row++) {
            listA[row] = new ArrayList<>();
            for (int col = 0; col < n; col++) {
                if (A[row][col] != 0) {
                    listA[row].add(col);
                }
            }
        }

        for (int rowA = 0; rowA < m; rowA++) {
            List<Integer> list = listA[rowA];

            for (int col = 0; col < k; col++) {
                int sum = 0;
                for (int row : list) {
                    if (B[row][col] != 0) {
                        sum += A[rowA][row] * B[row][col];
                    }
                }
                if (sum != 0) {
                    result[rowA][col] = sum;
                }
            }
        }

        return result;
    }
}
