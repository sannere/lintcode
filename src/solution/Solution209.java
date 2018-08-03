package solution;


import java.util.HashMap;


public class Solution209 {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        HashMap<Character,Integer> hash = new HashMap<>();


        for (; i < arr.length; i++) {
            if (!hash.containsKey(arr[i])) {
                hash.put(arr[i], 1);
            }
            else {
                int val = hash.get(arr[i]) + 1;
                hash.put(arr[i], val);
            }
        }
        System.out.println();
        i = 0;
        while (hash.get(arr[i]) != 1) {
            i++;
        }
        return arr[i];
    }
}
