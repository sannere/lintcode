package solution;

public class Solution28 {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0;

        while (row < matrix.length && matrix[row][matrix[0].length - 1] < target) {
            row++;
        }
        if (row == matrix.length) {
            return false;
        }
        int start = 0, end = matrix[0].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] > target) {
                end = mid;
            }
            else if (matrix[row][mid] < target) {
                start = mid;
            }
            else {
                return true;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        }
        if (matrix[row][end] == target) {
            return true;
        }

        return false;
    }
}
