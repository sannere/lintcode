package dataStructure;

public class NumMatrix_2 {
    public int[][] matrix, prefixSum;
    public NumMatrix_2(int[][] matrix) {
        this.matrix = matrix;
        prefixSum = new int[matrix.length + 1][matrix[0].length + 1];
        getPrefixSum();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] -
                prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
    }
    private void getPrefixSum() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                prefixSum[row + 1][col + 1] = prefixSum[row + 1][col] + prefixSum[row][col + 1] +
                        matrix[row][col] - prefixSum[row][col];
            }
        }
    }
}
