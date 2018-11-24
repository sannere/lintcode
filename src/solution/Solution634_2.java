package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution634_2 {
    /**
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    //1.get words.length得到square边长；
    // 2.在main中for循环，找第一个单词，然后dfs，向下匹配;---不用！
    // 3.DFS:有个记录list中单词数量的，visited记录都有哪些单词，每次都从words的第一个开始找;
    // 4.words数量最大为1000可以用数组。。

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        if (words == null || words.length == 0 ||words.length < words[0].length()) {
            return new ArrayList<>();
        }

        getPrefix(words, map);


        DFS(words, new ArrayList<>(), results, map);

        return results;
    }
    private void getPrefix(String[] words, Map<String, List<String>> map) {
        map.put("", new ArrayList<>());
        for (String word : words) {
            map.get("").add(word);
            for (int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0, i + 1);
                if (!map.containsKey(prefix)) {
                    map.put(prefix, new ArrayList<>());
                }
                map.get(prefix).add(word);
            }
        }
    }
    private void DFS(String[] words,
                     List<String> square,
                     List<List<String>> results,
                     Map<String, List<String>> map) {
        if (square.size() == words[0].length()) {
            results.add(new ArrayList<>(square));
            return;
        }

        int size = square.size();
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < size; i++) {
            prefix.append(square.get(i).charAt(size));
        }
        String prefixStr = prefix.toString();
        if (!map.containsKey(prefixStr)) {
            return;
        }
        for (String next : map.get(prefix.toString())) {
            square.add(next);
            DFS(words, square, results, map);
            square.remove(square.size() - 1);
        }
    }
}
