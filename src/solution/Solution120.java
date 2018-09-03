package solution;

import java.util.*;

public class Solution120 {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.isEmpty() || end.isEmpty() || start.length() != end.length()
                || start.equals(end)) {
            return 0;
        }

        int path = 1;
        Queue<String> queue = new LinkedList();
        ArrayList<String> list = new ArrayList();

        dict.add(end);
        Iterator<String> iter = dict.iterator();
        while (iter.hasNext()) {
            list.add(iter.next());
        }

        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while (size > 0) {
                String s = queue.poll();
                if (s.equals(end)) {
                    return path;
                }
                for (String t : list) {
                    if (transform(s, t)) {
                        queue.add(t);
                        list.remove(t);
                    }
                }
                size--;
            }
        }
        return 0;

    }
    private boolean transform(String s, String t) {
        int trans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                trans++;
            }
        }
        return trans == 1;
    }
}
