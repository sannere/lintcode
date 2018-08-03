package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution1401 {
    /**
     * @param str: the origin string
     * @return: the start and end of every twitch words
     */
    public int[][] twitchWords(String str) {
        char[] words = str.toCharArray();

        int[][] num = new int[words.length][2];
        int size = 0;

        for (int i = 0, j = i; i < words.length; i++) {
            j = i;
            while (j < words.length && words[j] == words[i]){
                j++;
            }
            j--;
            if (j - i >= 2) {
                num[size][0] = i;
                num[size][1] = j;
                i = j;
                size++;
            }
        }
        int[][] num2 = new int[size][2];
        for (int i = 0; i < size; i++) {
            num2[i] = num[i];
        }

        return num2;
    }
}
