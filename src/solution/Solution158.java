package solution;

public class Solution158 {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        char[] tArr = t.toCharArray();
        char ch;
        Boolean result = true;

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            int j = 0;
            while (j < tArr.length && tArr[j] != ch) {
                j++;
            }
            if (j < tArr.length && tArr[j] == ch) {
                tArr[j] = '&';
            }
            else {
                result = false;
            }

        }
        return result;
    }
}
