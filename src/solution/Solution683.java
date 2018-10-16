package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution683 {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        if (s == "" || dict.size() == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap();

        Set<String> LowerDict = new HashSet();
        for (String str : dict) {
            LowerDict.add(str.toLowerCase());
        }

        helper(s.toLowerCase(), 0, LowerDict, map);
        return helper(s.toLowerCase(), 0, LowerDict, map);
    }
    private int helper(String s,
                        int start,
                        Set<String> dict,
                       Map<Integer, Integer> map) {
        if (start == s.length()) {
            return 1;
        }

        if (map.containsKey(start)) {
            return map.get(start);
        }

        int num = 0;
        for (int i = start; i < s.length(); i++) {
            String prefix = s.substring(start, i + 1);

            if (!dict.contains(prefix)) {
                continue;
            }
            //dict did contains prefix
            num += helper(s, i + 1, dict, map);
        }
        map.put(start, num);
        return num;
    }
}
