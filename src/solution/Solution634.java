package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution634 {
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

        if (words == null || words.length == 0 ||words.length < words[0].length()) {
            return new ArrayList<>();
        }

        DFS(words, new ArrayList<>(), results);

        return results;
    }
    private void DFS(String[] words,
                     List<String> square,
                     List<List<String>> results) {
        if (square.size() == words[0].length()) {
            results.add(new ArrayList<>(square));
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!isvalid(words[i], square)) {
                continue;
            }

            square.add(words[i]);

            DFS(words, square, results);
            square.remove(square.size() - 1);

        }
    }
    private boolean isvalid(String word, List<String> square) {
        int n = square.size();
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) != square.get(i).charAt(n)) {
                return false;
            }
        }
        return true;
    }
}
