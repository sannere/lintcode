package solution;

public class Solution74_2 {/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 */
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int start = 1, end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
    private boolean isBadVersion(int n) {
        boolean[] versions= {false, false, false, false, true, true, true, true, true,true};
        return versions[n];
    }
}

