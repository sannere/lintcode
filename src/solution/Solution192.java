package solution;

public class Solution192 {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return helper(s, 0, p, 0, memo, visited);
    }
    private boolean helper(String source,
                           int s,
                           String pattern,
                           int p,
                           boolean[][] memo,
                           boolean[][] visited) {
        //pattern到头了，看source没有匹配完
        if (p == pattern.length()) {
            return s == source.length();
        }
        //source都匹配完了，如果pattern剩下的都是*，就为true，不然就是false
        if (s == source.length()) {
            while (p < pattern.length()) {
                if (pattern.charAt(p) != '*') {
                    return false;
                }
                p++;
            }
            return true;
        }

        if (visited[s][p]) {
            return memo[s][p];
        }
        char charP = pattern.charAt(p);
        char charS = source.charAt(s);

        boolean matched = false;
        //如果pattern的当前字符是*
        if (charP == '*') {
            matched = helper(source, s, pattern, p + 1, memo, visited) ||
                    helper(source, s + 1, pattern, p, memo, visited);
        }
        //pattern当前字符不是'*'
        else {
            matched = matchChar(charS, charP) &&
                    helper(source, s + 1, pattern, p + 1, memo, visited);
        }
        memo[s][p] = matched;
        visited[s][p] = true;
        return matched;
    }
    private boolean matchChar(char s, char p) {
        return p == '?' || p == s;
    }
}
