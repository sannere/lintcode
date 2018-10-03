package solution;

public class Solution154 {
    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return helper(s, 0, p, 0, memo, visited);
    }
    private boolean helper(String s, int i, String p, int j, boolean[][] memo, boolean[][] visited) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (i == s.length()) {
            for (int index = j; index < p.length(); index += 2) {//!!!
                if (index + 1 >= p.length() && p.charAt(index + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (visited[i][j]) {
            return memo[i][j];
        }

        boolean matched = false;
        char sChar = s.charAt(i);
        char pChar = p.charAt(j);

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            matched = helper(s, i, p, j + 2, memo, visited) ||
                    (charMatched(sChar, pChar) && helper(s, i + 1, p, j, memo, visited));
        }
        else {
            return charMatched(sChar, pChar) && helper(s, i + 1, p, j + 1, memo, visited);
        }

        visited[i][j] = true;
        memo[i][j] = matched;
        return matched;
    }
    private boolean charMatched(char s, char p) {
        return p == '.' || p == s;
    }
}
