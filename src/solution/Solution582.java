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
        List<String> list = new ArrayList();
        List<String> subword = new ArrayList();
        if (s == "") {
            return list;
        }
        helper(s, 0, subword, list, wordDict);
    }
    private void helper(String s,
                        int startIndex,
                        List<String> subword,
                        List<String> list,
                        Set<String> wordDict) {
        if (startIndex == s.length()) {
            String word = String.join(" ", subword);
            list.add(word);
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (!inDict(s, startIndex, i, wordDict)) {
                continue;
            }

            subword.add(s.substring(startIndex, i + 1));


            }
            word += " ";
            helper(s, i + 1, word, list, wordDict);

        }
    }
}
