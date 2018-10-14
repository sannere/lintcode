package solution;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution582 {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> results = new ArrayList();
        List<String> fragments = new ArrayList();
        boolean[] visited = new boolean[s.length()];
        boolean[] matched = new boolean[s.length()];

        if (s == "") {
            return results;
        }

        helper(s, 0, fragments, visited, matched, results, wordDict);
        return results;
    }

    private boolean helper(String s,
                        int start,
                        List<String> fragments,
                        boolean[] visited,
                        boolean[] matched,
                        List<String> results,
                        Set<String> wordDict) {
        if (start == s.length()) {
            results.add(getString(fragments));
            return true;
        }
        if (visited[start] && !matched[start]) {
            return false;
        }

        for (int i = start; i < s.length(); i++) {
            if (!wordDict.contains(s.substring(start, i + 1))) {
                continue;
            }
            fragments.add(s.substring(start, i + 1));
            if (helper(s, i + 1, fragments, visited, matched, results, wordDict)) {
                matched[start] = true;
            }
            fragments.remove(fragments.size() - 1);
        }
        visited[start] = true;
        return matched[start];
    }

    private String getString(List<String> fragments) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fragments.size() - 1; i++) {
            sb = sb.append(fragments.get(i));
            sb.append(" ");
        }
        sb.append(fragments.get(fragments.size() - 1));
        return sb.toString();
    }





}
