package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution680 {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        List<List<String>> results = new ArrayList();
        List<String> strings = new ArrayList();

        if (s == "") {
            return results;
        }
        if (s.length() == 1) {
            strings.add(s);
            results.add(strings);
            return results;
        }
        DFS(s, 0, results, strings);
        return results;
    }
    private void DFS(String s, int startIndex, List<List<String>> results, List<String> strings) {
        if (startIndex == s.length()) {
            results.add(new ArrayList(strings));
            return;
        }

        for (int i = startIndex; i < startIndex + 2 && i < s.length(); i++) {
            strings.add(s.substring(startIndex, i + 1));
            DFS(s, i + 1, results, strings);
            strings.remove(strings.size() - 1);
        }
    }
}
