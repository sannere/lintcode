package solution;

import java.util.*;

public class Solution582_2 {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap();
        return helper(s, wordDict, map);
    }
    private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> results = new ArrayList();
        if (wordDict.contains(s)) {
            results.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String pre = s.substring(0, i);
            if (!wordDict.contains(pre)) {
                continue;
            }

            List<String> sufResults = helper(s.substring(i), wordDict, map);
            for (String suffix : sufResults) {
                results.add(pre + " " + suffix);
            }
        }

        map.put(s, results);
        return results;
    }
}
