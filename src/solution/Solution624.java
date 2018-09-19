package solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution624 {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        if (s.isEmpty() || dict.contains(s)) {
            return 0;
        }
        if (dict == null || dict.size() == 0) {
            return s.length();
        }
        Queue<String> queue = new LinkedList();
        HashSet<String>  set = new HashSet();
        int length = s.length();

        queue.offer(s);
        set.add(s);

        while (!queue.isEmpty()) {
            String string = queue.poll();

            length = Math.min(length, string.length());
            for (String target : dict) {

                remove(string, target, queue, set);
            }
        }
        return length;

    }
    private void remove(String s, String target, Queue<String> queue, HashSet<String> set) {
        if (s.length() < target.length()) {
            return;
        }
        if (s.equals(target)) {
            queue.offer("");
        }
        for (int start = 0; start <= s.length() - target.length(); start++) {
            int i = start, j = 0;
            while (i < s.length() && j < target.length() && s.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            }
            if (j == target.length()) {
                String SubString = s.substring(0,i - j) + s.substring(i);
                if (!set.contains(SubString)) {
                    queue.offer(SubString);
                    set.add(SubString);
                    System.out.println(SubString);
                }

            }
        }
    }

}