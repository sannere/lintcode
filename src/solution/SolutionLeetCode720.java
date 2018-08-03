package solution;

import java.util.HashSet;

public class SolutionLeetCode720 {
    public String longestWord(String[] words) {
        String s = "";
        int length = 0;
        HashSet<String> hash = new HashSet();

        for (String str : words) {
            hash.add(str);
        }

        for (String str : words) {
            int i = 1;
            if (str.length() > length || (str.length() == length && str.compareTo(s) < 0)) {
                while (i < str.length() && hash.contains(str.substring(0, i))) {
                    i++;
                }
                if (i == str.length()) {
                    length = str.length();
                    s = str;
                }
            }
        }

        return s;
    }

}
