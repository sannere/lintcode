package solution;


import java.util.ArrayList;
import java.util.List;


public class Solution460 {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null && A.length == 0 || k == 0) {
            return new int[0];
        }

        int[] results = new int[k];
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        for (int i = 0; i < k; i++) {
            if (start < 0) {
                results[i] = A[end];
                end++;
                continue;
            }
            if (end >= A.length) {
                results[i] = A[start];
                start--;
                continue;
            }
            if (Math.abs(A[start] - target) <= Math.abs(A[end] - target)) {
                results[i] = A[start];
                start--;
                continue;
            }
            if (Math.abs(A[start] - target) > Math.abs(A[end] - target)) {
                results[i] = A[end];
                end++;
                continue;
            }
        }

        return results;
    }

}
