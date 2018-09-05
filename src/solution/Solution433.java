package solution;


import java.util.LinkedList;
import java.util.Queue;

class coordinate {
    public int x, y;
    public coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Solution433 {
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int line = 0; line < grid[0].length; line++) {
                if (grid[row][line]) {
                    BFS(grid, row, line);
                    islands++;
                }
            }
        }

        return islands;
    }
    private void BFS(boolean[][] grid, int row, int line) {
        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};
        Queue<coordinate> queue = new LinkedList();

        queue.offer(new coordinate(row, line));
        grid[row][line] = false;

        while (!queue.isEmpty()) {
            coordinate land = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = land.x, y = land.y;
                x += directionX[i];
                y += directionY[i];
                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y]) {
                    queue.add(new coordinate(x, y ));
                    grid[x][y] = false;
                }
            }
        }
    }
}
