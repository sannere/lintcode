package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution425 {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    String[] board = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList();

        if (digits == null || digits.equals("")) {
            return results;
        }

        helper(digits, 0, "", results);
        return results;
    }
    private void helper(String digits, int startIndex, String combination, List<String> results) {
        if (startIndex == digits.length()) {
            results.add(combination);
        }

        int digit = digits.charAt(startIndex);

        for (char c : board[digit].toCharArray()) {
            helper(digits, startIndex + 1, combination + c, results);
        }
    }
}
