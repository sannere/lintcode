package solution;

public class Solution116_2 {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        int farthest = A[0];
        for (int i = 0; i < A.length; i++) {
            farthest = Math.max(farthest, i + A[i]);
            if (farthest >= A.length - 1) {
                return true;
            }
            if (farthest == i) {
                return false;
            }
        }
        return false;
    }
}
