package solution;

public class Solution74 {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int start = 0, end = n - 1, mid = 0;

        if (n <= 1) {
            return n;
        }

        while (start + 1 < end) {
            mid = start + (end - start) / 2;

            if (!isBadVersion(mid)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (isBadVersion(start)) {
            return start;
        }
        if (isBadVersion(end)) {
            return end;
        }
        return mid;
    }
    private boolean isBadVersion(int n) {
        boolean[] versions= {false, false, false, false, true, true, true, true, true,true};
        return versions[n];
    }

}

