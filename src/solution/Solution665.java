package solution;
import dataStructure.NumMatrix_2;

public class Solution665 {
    public void getNumMatrixSum(int[][] matrix) {
        NumMatrix_2 m = new NumMatrix_2(matrix);
        int x = m.sumRegion(0, 4, 0, 6);
        int y = m.sumRegion(1,1,2,2);
        int z = m.sumRegion(1,2,2,4);
    }
}
