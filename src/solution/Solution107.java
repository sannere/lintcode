package solution;

import java.util.*;

public class Solution107 {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.equals("") && dict.size() == 0) {
            return true;
        }

        int len = s.length();
        int max = 0;

        Queue<Integer> queue = new LinkedList();

        for(String str : dict) {
            if (str.length() > max) {
                max = str.length();
            }
        }

        for (int head = len - 1; head >= 0; head--) {
            boolean isvalid = false;
            if (head >= len - max) {
                String str = s.substring(head,len);
                if (dict.contains(str)) {
                    isvalid = true;
                }
            }

            for (int i : queue) {
                String sub = s.substring(head, i);
                if (dict.contains(sub)) {
                    isvalid = true;
                }
            }

            if (isvalid) {
                if (queue.size() > max) {
                    queue.poll();
                }
                queue.offer(head);
            }
        }

        return queue.contains(0);
    }

}
