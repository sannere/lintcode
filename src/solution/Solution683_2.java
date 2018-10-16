package solution;

import java.util.HashSet;
import java.util.Set;

public class Solution683_2 {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict.size() == 0) {
            return 0;
        }

        Set<String> lowerDict = new HashSet();
        String lowerS = s.toLowerCase();
        int len = s.length();

        for (String str : dict) {
            lowerDict.add(str.toLowerCase());
        }

        int[][] dp = new int[len][len];

        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                String sub = lowerS.substring(left, right + 1);
                if (lowerDict.contains(sub)) {
                    dp[left][right] = 1;
                }
            }
        }

        for (int end = 1; end < len; end++) {
            for (int mid = 0; mid < end; mid++) {
                dp[0][end] += dp[0][mid] * dp[mid + 1][end];
            }
        }

        return dp[0][len - 1];
    }
}
