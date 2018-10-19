package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution10_2 {
    public List<String> stringPermutation2(String str) {
        List<String> results = new ArrayList();

        if (str == null || str.length() == 0) {
            results.add("");
            return results;
        }

        char[] s = str.toCharArray();
        Arrays.sort(s);

        while (s != null) {
            results.add(String.valueOf(s));
            s = getNext(s);
        }
        return results;
    }
    private char[] getNext(char[] s) {
        int index = -1;
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i] > s[i - 1]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            return null;
        }

        for (int i = s.length - 1; i > index; i--) {
            if (s[i] > s[index]) {
                swap(s, index, s.length - 1);
                break;
            }
        }

        for (int i = index + 1,j = s.length - 1; i < j; i++, j--) {
            swap(s, i ,j);
        }

        return s;
    }
    private void swap(char[] s ,int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
