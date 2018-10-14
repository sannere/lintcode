package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution780 {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList();

        if (s.length() <= 1) {
            return results;
        }
        helper();
        return results;
    }

}
