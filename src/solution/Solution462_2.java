package solution;

public class Solution462_2 {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length ==0) {
            return 0;
        }

        int right = findRight(A, target);

        return getNumbers(A, target, right);
    }
    private int findRight(int[] A, int target) {
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (A[end] == target) {
            return end;
        }
        if (A[start] == target) {
            return start;
        }

        return -1;
    }
    private int getNumbers(int[] A, int target, int right) {
        if (right == -1) {
            return 0;
        }
        int result = 0;
        while (right >= 0 && A[right] == target) {
            result++;
        }
        return result;
    }
}
