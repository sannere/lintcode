package solution;

public class Solution116 {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        for (int i = 0; i < A.length; i++) {
            if (dp[i]) {
                for (int step = 1; step <= A[i] && i + step < A.length; step++) {
                    dp[i + step] = true;
                }
            }
        }
        return dp[A.length - 1];
    }
}
