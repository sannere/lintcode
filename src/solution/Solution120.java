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
        if (start.isEmpty() || end.isEmpty() || start.equals(end)) {
            return 0;
        }

        int path = 0;
        Queue<String> queue = new LinkedList();
        HashSet<String> set = new HashSet();

        dict.add(end);

        queue.offer(start);
        set.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;

            while (size > 0) {
                String word = queue.poll();


                if (word.equals(end)) {
                    return path;
                }

                for (int i = 0; i < word.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        String nextWord = word.substring(0,i) + ch + word.substring(i + 1);
                        //find a new nextword in dict:
                        if (!word.equals(nextWord) && dict.contains(nextWord) && !set.contains(nextWord)) {
                            queue.offer(nextWord);
                            set.add(nextWord);
                        }
                    }
                }
                size--;
            }
        }
        return 0;
    }
}
