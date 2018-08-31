package solution;

public class Solution459 {
    /**
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;

        if (target > A[end]) {
            return end;
        }
        if (target < A[0]) {
            return 0;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            }
            else if (A[mid] < target) {
                start = mid;
            }
            else {
                return mid;
            }
        }

        return (target - A[start]) < (A[end] - target) ? start : end;
    }
}
