package solution;

public class Solution38 {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        int result = 0;
        for (int row = 0, line = matrix[0].length; line >= 0 && row < matrix.length; ) {
            if (matrix[row][line] == target) {
                result++;
                line--;
                row++;
            }
            else if (matrix[row][line] > target) {
                line--;
            }
            else {
                row++;
            }
        }
        return result;
    }
}
