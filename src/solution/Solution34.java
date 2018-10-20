package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution34 {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    int result;
    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        result = 0;
        List<Integer> lines = new ArrayList();


        Set<Integer> visitedLine = new HashSet();
        Set<Integer> visitedSum = new HashSet();
        Set<Integer> visitedDiff = new HashSet();

        placeQueens(n, visitedLine, visitedSum, visitedDiff, lines);
        return result;
    }
    private void placeQueens(int n,
                             Set<Integer> visitedLine,
                             Set<Integer> visitedSum,
                             Set<Integer> visitedDiff,
                             List<Integer> lines) {
        int row = lines.size();
        if (row == n) {
            result++;
            return;
        }

        for (int line = 0; line < n; line++) {
            if (!isvalid(visitedLine, visitedSum, visitedDiff, row, line)) {
                continue;
            }
            visitedLine.add(line);
            visitedSum.add(line + row);
            visitedDiff.add(line - row);
            lines.add(line);
            placeQueens(n, visitedLine, visitedSum, visitedDiff, lines);
            visitedLine.remove(line);
            visitedSum.remove(line + row);
            visitedDiff.remove(line - row);
            lines.remove(lines.size() - 1);
        }
    }
    private boolean isvalid(Set<Integer> visitedLine,
                            Set<Integer> visitedSum,
                            Set<Integer> visitedDiff,
                            int row,
                            int line) {
        return !visitedLine.contains(line) &&
                !visitedSum.contains(line + row) &&
                !visitedDiff.contains(line - row);
    }
}
