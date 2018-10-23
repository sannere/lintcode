package solution;

import java.util.*;

public class Solution121 {
    /**
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    //预处理dict: (最后再优化吧。。。)
    //1.DFS查找路径；
    // 2.找到下一个点，用BFS求距离终点的距离；
    // 3.比较当前点的距离是不是最小的，
    //   如果>min，return；
    //   如果 == min, 继续往下走；
    //   如果 < min,把results清空，添加这条路径，更新min

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> results = new ArrayList<>();
        Map<String, Integer> distance = new HashMap<>();
        Map<String, Set<String>> nextWords = new HashMap<>();
        List<String> path = new ArrayList<>();

        path.add(start);
        dict.add(end);
        dict.add(start);

        getDistance(start, end, distance, dict, nextWords);

        DFS(start, end, distance, path, results, nextWords);
        return results;
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
    private void getNext(Set<String> dict, String start,Map<String, Set<String>> nextWords) {
        if (nextWords.containsKey(start)) {
            return;
        }
        Set<String> next = new HashSet<>();
        for (int i = 0; i < start.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String s = start.substring(0, i) + c + start.substring(i + 1);
                if (dict.contains(s)) {
                    next.add(s);
                }
            }
        }
        next.remove(start);
        nextWords.put(start, next);
    }
    private void getDistance(String start,
                             String end,
                             Map<String, Integer> distance,
                             Set<String> dict,
                             Map<String, Set<String>> nextWords) {

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int length = 0;

        queue.offer(end);
        set.add(end);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                String s = queue.poll();
                distance.put(s, length);
                getNext(dict,s,nextWords);

                if (s.equals(start)) {
                    return;
                }
                for (String next : nextWords.get(s)) {
                    if (set.contains(next)) {
                        continue;
                    }
                    queue.offer(next);
                    set.add(next);
                }
                size--;
            }
            length++;
        }
    }
}
