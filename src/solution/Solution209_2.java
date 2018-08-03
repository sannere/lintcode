package solution;

public class Solution209_2 {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        char[] arr = str.toCharArray();
        int[] chars = new int[256];
        System.out.println("chars[arr[0]]:" + chars[arr[0]] + "   chars[1]:" + chars[1]);
        int i = 0;

        for (char ch : arr) {
            chars[ch]++;
        }

        while (chars[arr[i]] != 1) {
            i++;
        }
        return arr[i];
    }
}
