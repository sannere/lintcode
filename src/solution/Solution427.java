package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution427 {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList();

        if (n == 0) {
            return results;
        }

        helper(n, 1, 0, results, "");
        return results;
    }
    private void helper(int n,
                        int leftNum,//画第leftNum个"（"
                        int rightNum,//已经画过的"）"的个数
                        List<String> results,
                        String str) {
        str += "(";

        if (n == leftNum) {
            while (n > rightNum) {
                str += ")";
                rightNum++;
            }
            results.add(str);
            return;
        }

        // n > leftNum
        for (int i = 0; i <= leftNum - rightNum; i++) {
            helper(n, leftNum + 1, rightNum + i, results, str);
            str += ")";
        }
    }
}
