package solution;

import java.util.Set;

public class Solution107_2 {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        int max = 0;

        dp[0] = true;
        for(String str : dict) {
            if (str.length() > max) {
                max = str.length();
            }
        }

        for (int sumLen = 1; sumLen <= len; sumLen++) {
            for (int subLen = 1; subLen <= sumLen && subLen <= max; subLen++) {
                if (dp[sumLen - subLen] && dict.contains(s.substring(sumLen - subLen, sumLen))) {
                    dp[sumLen] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
