package solution;

public class Solution65 {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (A == null || m == 0) {
            return medianOfOneArray(B);
        }
        if (B == null || n == 0) {
            return medianOfOneArray(A);
        }

        double[] result = new double[2];
        getKthNum(A, 0, B, 0, (m + n) / 2, result);

        if ((m + n) % 2 != 0 ){
            return result[1];
        }
        return result[0] / 2 + result[1] / 2;
    }
    private double medianOfOneArray(int[] nums) {
        int middle = nums.length / 2;
        if (nums.length % 2 == 0) {
            return nums[middle] / 2 + nums[middle + 1] / 2;
        }
        return nums[middle + 1];
    }
    private void getKthNum(int[] A, int a, int[] B, int b, int k, double[] result) {
        if (a >= A.length) {
            result[0] = B[b + k - 1];
            result[1] = B[b + k];
            return;
        }
        if (b >= B.length) {
            result[0] = A[a + k - 1];
            result[1] = A[a + k];
            return;
        }


        if (k == 1) {
            if (A[0] < B[0]) {
                result[0] = A[a];
                result[1] = (a == A.length - 1) ? B[b] : Math.min(A[a + 1], B[b]);

            }
            else {
                result[0] = B[b];
                result[1] = (b == B.length - 1) ? A[a] : Math.min(B[b + 1], A[a]);
            }
            return;
        }

        int delete = k / 2;
        if (a + delete >= A.length) {
            getKthNum(A, a, B, b + delete, k - delete, result);
            return;
        }
        if (b + delete >= B.length) {
            getKthNum(A, a + delete, B, b, k - delete, result);
            return;
        }

        if (A[a + delete - 1] < B[b + delete - 1]) {
            getKthNum(A, a + delete, B, b, k - (delete), result);
        } else {
            getKthNum(A, a, B, b + delete, k - (delete), result);
        }
    }
}
