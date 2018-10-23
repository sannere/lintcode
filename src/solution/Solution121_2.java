package solution;

import java.util.*;

public class Solution121_2 {
    /**
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    //在原本的基础上，优化对dict的预处理，用%代替变更的pattern

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> results = new ArrayList<>();
        Map<String, Integer> distance = new HashMap<>();
        Map<String, Set<String>> dictPattern = new HashMap<>();
        Map<String, Set<String>> nextWords = new HashMap<>();
        List<String> path = new ArrayList<>();

        dict.add(end);
        dict.add(start);
        path.add(start);
        //预处理dict pattern
        getPattern(dict, dictPattern);

        BFS(start, end, distance, nextWords, dictPattern);

        DFS(start, end, distance, path, results, nextWords);
        return results;
    }
    private void getPattern(Set<String> dict, Map<String, Set<String>> dictPattern) {
        for (String s : dict) {
            for (int i = 0; i < s.length(); i++) {
                String pattern = s.substring(0, i) + '%' + s.substring(i + 1);
                if (!dictPattern.containsKey(pattern)) {
                    dictPattern.put(pattern, new HashSet<>());
                }
                dictPattern.get(pattern).add(s);
            }
        }
    }
    private void BFS(String start,
                     String end,
                     Map<String, Integer> distance,
                     Map<String, Set<String>> nextWords,
                     Map<String, Set<String>> dictPattern) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);
        distance.put(end, 0);

        while (!queue.isEmpty()) {
            String s = queue.poll();

            Set<String> nextSet = getNext(s,  dictPattern);
            nextWords.put(s, nextSet);

            if (s.equals(start)) {
                return;
            }

            for (String next : nextSet) {
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(s) + 1);
                    queue.add(next);
                }
            }
        }
    }
    private Set<String> getNext(String s,
                         Map<String, Set<String>> dictPattern) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            String pattern = s.substring(0, i) + '%' + s.substring(i + 1);
            set.addAll(dictPattern.get(pattern));
        }
        set.remove(s);
        return set;
    }
    private void DFS(String start, //已经在当前path中了,肯定是求过距离的点
                     String end,
                     Map<String, Integer> distance,//to the end
                     List<String> path,
                     List<List<String>> results,
                     Map<String, Set<String>> nextWords) {
        if (start.equals(end) ) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (String next : nextWords.get(start)) {
            if (distance.containsKey(next) && distance.get(next) == distance.get(start) - 1) {
                path.add(next);
                DFS(next, end, distance, path, results, nextWords);
                path.remove(path.size() - 1);
            }
        }
    }
}
