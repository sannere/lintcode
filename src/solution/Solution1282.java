package solution;

public class Solution1282 {

        /**
         * @param s: a string
         * @return: reverse only the vowels of a string
         */
        public String reverseVowels(String s) {
            char[] vowels = {'a','e','i','o','u'};
            char ch;
            StringBuilder sb = new StringBuilder(s);
            if (s.isEmpty()) {
                return "";
            }
            for (int i = 0, j = s.length() -1; i < j; i++, j--) {
                while (!isVowel(vowels, Character.toLowerCase(s.charAt(i)))) {
                    i++;
                }
                while (!isVowel(vowels, Character.toLowerCase(s.charAt(j)))) {
                    j--;
                }
                if (i < j) {
                    ch = s.charAt(j);
                    sb.setCharAt(j, s.charAt(i));
                    sb.setCharAt(i, ch);
                }
            }
            return sb.toString();
        }

        private boolean isVowel(char[] v, char ch) {
            for (int i = 0; i < v.length; i++) {
                if (v[i] == ch) {
                    return true;
                }
            }
            return false;
        }

}
