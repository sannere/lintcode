package solution;

public class Solution433_2 {
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int line = 0; line < grid[0].length; line++) {
                if (grid[row][line]) {
                    DFS(grid, row, line);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void DFS(boolean[][] grid, int row, int line) {
        if (row < 0 || line < 0 || row >= grid.length || line >= grid[0].length) {
            return;
        }
        if (grid[row][line]) {
            grid[row][line] = false;
            DFS(grid, row + 1, line);
            DFS(grid, row - 1, line);
            DFS(grid, row, line + 1);
            DFS(grid, row, line - 1);
        }
    }
}
