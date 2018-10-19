package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution10 {
    public List<String> stringPermutation2(String str) {
        List<String> results = new ArrayList();
        boolean[] visited = new boolean[str.length()];//true: is visited

        if (str == null || str.length() == 0) {
            return results;
        }
        String sortedStr = sort(str);
        helper(sortedStr, visited, "", results);
        return results;
    }
    private String sort(String s) {
         char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
    private void helper(String str, boolean[] visited, String permutation, List<String> results) {
        if (permutation.length() == str.length()) {
            results.add(permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (visited[i] || i > 0 && str.charAt(i - 1) == str.charAt(i) && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            helper(str, visited, permutation + str.charAt(i), results);
        }
    }
}
