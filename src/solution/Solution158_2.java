package solution;

public class Solution158_2 {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        int[] charNum = new int[26];
        char[] arr = s.toCharArray();

        for (char ch : arr) {
            charNum[ch - 'a']++;
        }

        arr = t.toCharArray();

        for (char ch : arr) {
            charNum[ch - 'a']--;
        }

        for (int i : charNum) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
