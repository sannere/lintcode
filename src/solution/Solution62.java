package solution;

public class Solution62 {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;
        int border = A[end];


        while (start < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] > border) {
                start = mid + 1;
            }
            else if (A[mid] < border) {
                end = mid;
            }
        }
        if (target < border) {
            end = A.length - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;

                if (A[mid] > target) {
                    end = mid;
                }
                else if (A[mid] < target) {
                    start = mid + 1;
                }
                else {
                    return mid;
                }
            }
            if (A[start] == target) {
                return start;
            }
            return -1;

        }
    }
}
