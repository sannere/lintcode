package dataStructure;

class NumMatrix {

    int[][] prefixSum;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length][matrix[0].length + 1];
        this.matrix = matrix;
        for (int i = 0; i < matrix.length; i++) {
            getPrefixSum(matrix[i], prefixSum[i]);
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i = col + 1; i < prefixSum[0].length; i++) {
            prefixSum[row][i] += diff;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += (prefixSum[row][col2 + 1] - prefixSum[row][col1]);
        }
        return sum;
    }
    private void getPrefixSum(int[] arr, int[] prefix) {
        prefix[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
