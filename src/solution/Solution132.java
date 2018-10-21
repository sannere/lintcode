package solution;

import java.util.*;

public class Solution132 {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */

    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<String> wordSearchII(char[][] board, List<String> words) {
        if (words == null || words.size() == 0 ||
                board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }

        int row = board.length, line = board[0].length;
        Set<String> prefix = getPrefix(words);
        Set<String> set = new HashSet<>();

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < line; y++) {
                helper(board, new boolean[row][line], x, y, words, "", prefix, set);
            }
        }

        return new ArrayList<>(set);
    }

    private void helper(char[][] board,
                        boolean[][] visited,
                        int x,
                        int y,
                        List<String> words,
                        String s,
                        Set<String> prefix,
                        Set<String> set) {//results需要去重
        //出口：1.s是个word，添加到results中，它有可能还是个prefix，所以此时不return
        //     2.s不是个prefix，直接return

        if (words.contains(s)) {
            set.add(s);
        }
        if (!prefix.contains(s)) {
            return;
        }

        //可以走一步的条件：
        // 1.该位置没有出边界；
        // 2.该位置从来没有visited过；


        for (int direc = 0; direc < 4; direc++) {
            int i = x + direction[direc][0];
            int j = y + direction[direc][1];

            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                    visited[i][j]) {
                continue;
            }

            visited[i][j] = true;

            helper(board, visited, i, j, words, s + board[i][j], prefix, set);

            visited[i][j] = false;
        }
    }
    private Set<String> getPrefix(List<String> words) {
        Set<String> prefix = new HashSet();
        prefix.add("");

        for (String s :words) {
            for (int i = 0; i < s.length() - 1; i++) {
                prefix.add(s.substring(0, i + 1));
            }
        }

        return prefix;
    }
}
