package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution33_2 {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    boolean[] visitedLine;
    boolean[] visitedSum;
    boolean[] visitedDiff;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList();
        List<Integer> lines = new ArrayList();

        visitedLine = new boolean[n];
        visitedSum = new boolean[2 * n + 1];
        visitedDiff = new boolean[2 * n + 1];


        if (n == 0) {
            results.add(new ArrayList());
            return results;
        }

        placeQueens(n, lines, results);
        return results;
    }

    private void placeQueens(int n,
                             List<Integer> lines,
                             List<List<String>> results) {
        int row = lines.size();
        if (row == n) {
            results.add(drawBoard(lines));
        }

        for (int line = 0; line < n; line++) {
            if (!isvalid(row, line)) {
                continue;
            }
            visitedLine[line] = true;
            visitedSum[line + row] = true;
            visitedDiff[line - row + n] = true;
            lines.add(line);
            placeQueens(n, lines, results);
            visitedLine[line] = false;
            visitedSum[line + row] = false;
            visitedDiff[line - row + n] = false;
            lines.remove(lines.size() - 1);
        }
    }

    private boolean isvalid(int row, int line) {
        return !visitedLine[line] &&
                !visitedSum[line + row] &&
                !visitedDiff[line - row + visitedLine.length];
    }

    private List<String> drawBoard(List<Integer> lines) {
        int n = lines.size();
        List<String> board = new ArrayList();

        for (int line : lines) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == line) {
                    row.append('Q');
                    continue;
                }
                row.append('.');
            }
            board.add(row.toString());
        }

        return board;
    }
}
