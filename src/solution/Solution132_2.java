package solution;

import java.util.ArrayList;
import java.util.List;
class TrieNode {
    String word;
    TrieNode[] children = new TrieNode[26];
}
public class Solution132_2 {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    //trie实现：数组(指针) + 字符串（如果是个word就存；否则为空）
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<String> wordSearchII(char[][] board, List<String> words) {
        if (board == null || board.length == 0 ||
                board[0] == null || board[0].length == 0) {
            return new ArrayList();
        }

        int row = board.length, line = board[0].length;
        List<String> results = new ArrayList();
        TrieNode root = new TrieNode();

        for (String s : words) {
            insert(root, s);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (root.children[board[i][j] - 'a'] != null){
                    searchWord(root.children[board[i][j] - 'a'], board, i, j, results);
                }
            }
        }

        return results;
    }
    private void insert(TrieNode root, String s) {
        int wordLen = 0, strLen = s.length();
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (root.children[index] == null) {
                root.children[index] = new TrieNode();
            }
            root = root.children[index];
            wordLen++;
            if (wordLen == strLen) {
                root.word = s;
            }
        }
    }
    private void searchWord(TrieNode root,
                             char[][] board,
                             int x,
                             int y,
                             List<String> results
                             ) {
        if (root.word != null && !results.contains(root.word)) {
            results.add(root.word);
        }

        char temp = board[x][y];
        board[x][y] = '*';
        for (int direc = 0; direc < 4; direc++) {
            int i = x + direction[direc][0];
            int j = y + direction[direc][1];
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*') {
                continue;
            }
            if (root.children[board[i][j] - 'a'] == null) {
                continue;
            }

            searchWord(root.children[board[i][j] - 'a'], board, i, j, results);
        }
        board[x][y] = temp;
    }
}
