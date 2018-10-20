package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution33 {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList();
        List<Integer> lines = new ArrayList();

        Set<Integer>[] placement = new HashSet[3];
        placement[0] = new HashSet();
        placement[1] = new HashSet();
        placement[2] = new HashSet();
        //set[0]:line
        //set[1]:\
        //set[2]:/

        if (n == 0) {
            results.add(new ArrayList());
            return results;
        }

        placeQueens(n, placement, lines, results);
        return results;
    }
    private void placeQueens(int n,
                             Set<Integer>[] placement,
                             List<Integer> lines,
                             List<List<String>> results) {
        int row = lines.size();
        if (row == n) {
            results.add(drawBoard(lines));
        }

        for (int line = 0; line < n; line++) {
            if (!isvalid(placement, row, line)) {
                continue;
            }
            placement[0].add(line);
            placement[1].add(line + row);
            placement[2].add(line - row);
            lines.add(line);
            placeQueens(n, placement, lines, results);
            placement[0].remove(line);
            placement[1].remove(line + row);
            placement[2].remove(line - row);
            lines.remove(lines.size() - 1);
        }
    }
    private boolean isvalid(Set<Integer>[] placement, int row, int line) {
        if (placement[0].contains(line)) {
            return false;
        }
        if (placement[1].contains(line + row)) {
            return false;
        }
        if (placement[2].contains(line - row)) {
            return false;
        }
        return true;
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
