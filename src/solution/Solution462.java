package solution;

public class Solution462 {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0 ) {
            return 0;
        }

        int start = 0, end = A.length - 1, result = 0, mid = -1, len = A.length;

        while (start < end) {
            mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid + 1;
            }
            else if (A[mid] > target) {
                end = mid - 1;
            }
            else {
                result++;
                break;
            }
        }
        if (result == 0 && A[start] == target) {
            mid = start;
        }

        for (int i = 0; mid + i < len && mid - i >= 0; i++) {
            if (A[mid + i] == target) {
                result++;
            }
            if (A[mid - i] == target) {
                result++;
            }
        }

        return result;
    }

}
