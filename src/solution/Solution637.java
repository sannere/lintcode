package solution;

public class Solution637 {
    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0, num = 0;
        if (abbr.isEmpty()) {
            return false;
        }
        for (; i < word.length() || j < abbr.length(); i++, j++) {
            if (word.charAt(i) != abbr.charAt(j) && (abbr.charAt(j)  > '9' || abbr.charAt(j) < '0')) {
                return false;
            }
            else if (abbr.charAt(j) <= '9' && abbr.charAt(j) >= '0'){
                while (j < abbr.length() && abbr.charAt(j) <= '9' && abbr.charAt(j) >= '0') {
                    num = num * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                j--;
                i = i + num - 1;
                num = 0;
            }
        }
        if (i - word.length() == j - abbr.length()) {
            return true;
        }
        else {
            return false;
        }
    }
}
