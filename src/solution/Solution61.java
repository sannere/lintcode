package solution;

public class Solution61 {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] results = {-1,-1};
        if (A == null || A.length == 0) {
            return results;
        }

        int left = -1, right = -1;
        int start = 0, end = A.length - 1;

        //get left
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = target;
            }
            else {
                end = target;
            }
        }
        if (A[start] == target) {
            left = start;
        }
        if (A[end] == target) {
            left = end;
        }

        if (left == -1) {//can't find target
            return results;
        }
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = target;
            }
            else {
                start = target;
            }
        }
        if (A[end] == target) {
            right = end;
        }
        if (A[start] == target) {
            right = start;
        }

        results[0] = left;
        results[1] = right;
        return results;
    }
}
