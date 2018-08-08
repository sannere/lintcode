package solution;

import java.util.Hashtable;

public class Solution841 {
    /**
     * @param a: The A array
     * @param b: The B array
     * @param s: The S string
     * @return: The answer
     */
    public String stringReplace(String[] a, String[] b, String s) {
        Hashtable<Integer, Integer> hash = new Hashtable();//key: index of s, value: index of a[]
        int sIndex = s.length();


        for (int i = 0; i < a.length; i++) {
            int index = isSubstring(s,a[i]);
            int startIndex;
          //  int hash.get(index) = hash.get(index);
            if (index != -1 ) {//a[i]是s的子字符串
                if (sIndex == s.length()) {
                    hash.put(index,i);
                    sIndex = index;
                }
                else if (index < sIndex) {// {a[i]是新的最左的子字符串
                    startIndex = index + a[i].length();
                    renewHash(s.substring(startIndex), a,hash.get(sIndex), hash,startIndex);
                    sIndex = index;
                    hash.put(sIndex,i);
                }
                else if (index == sIndex && a[i].length() > a[hash.get(index)].length()) {
                    startIndex = index + a[i].length();
                    renewHash(s.substring(startIndex),a,hash.get(sIndex),hash,startIndex);
                    hash.put(sIndex,i);
                }
                else if (index == sIndex && a[i].length() < a[hash.get(index)].length() || index > sIndex) {
                    startIndex = sIndex + a[hash.get(sIndex)].length();
                    renewHash(s.substring(startIndex),a,i,hash,startIndex);
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (hash.containsKey(i)) {
                String str = b[hash.get(i)];
                s = s.substring(0,i) + str + s.substring(i + str.length());
            }
        }


        return s;


    }
    private int isSubstring(String s, String t) {
        int index = -1, i = 0, j = 0;

        if (s.length() < t.length()) {
            return index;
        }

        while (i < s.length() && j < t.length()) {
            while (i < s.length() && s.charAt(i) != t.charAt(j)) {
                i++;
            }
            while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            if (j == t.length()) {
                index = i - j;
            }
            else {
                i = i - j + 1;
                j = 0;
            }
        }

        return index;
    }
    private void makeHash(String s, String[] arr, int i, Hashtable<Integer,Integer> hash, int start, int small) {
        int index = isSubstring(s, arr[i]);

        if (index != -1) {
            index += start;
            if (index > small)
            index = index + start;
            if (hash.containsKey(index)) {
                start = index + arr[i].length();
                renewHash(s.substring(start), arr, hash.get(index), hash,start);
                hash.put(index, i);
            } else {
                hash.put(index, i);
            }
        }
    }
}
