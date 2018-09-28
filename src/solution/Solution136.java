package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution136 {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList();
        List<String> partition = new ArrayList();

        if (s == "") {
            return results;
        }
        if (s.length() == 1) {
            partition.add(s);
            results.add(partition);
            return results;
        }

        boolean[][] arr = new boolean[s.length()][s.length()];
        isPalindrome(s, arr);

        DFS(s, 0, results, partition, arr);
        return results;
    }

    private void DFS(String s,
                     int startIndex,
                     List<List<String>> results,
                     List<String> partition,
                     boolean[][] arr) {
        if (startIndex == s.length()) {
            results.add(new ArrayList(partition));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (arr[startIndex][i]) {
                partition.add(s.substring(startIndex, i + 1));
                DFS(s, i + 1, results, partition, arr);
                partition.remove(partition.size() - 1);
            }
        }
    }
    private void isPalindrome(String s, boolean[][] arr) {
        int n = arr.length - 1;

        for (int i = 1; i < arr.length; i++) {
            arr[i][i] = true;
            arr[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }
        arr[0][0] = true;

        for (int len = 2; len < arr.length; len++) {
            for (int i = 0; i < arr.length - len; i++) {
                arr[i][i + len] = s.charAt(i) == s.charAt(i + len) && arr[i + 1][i + len -1];
            }
        }
    }
}
