package solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution598 {
    /*
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    class coordinate {
        int x,y;
        coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int row, line, day = 0, peopleNum = 0;

        Queue<coordinate> queue = new LinkedList();
        //find all zombies
        for (row = 0; row < grid.length; row++) {
            for (line = 0; line < grid[0].length; line++) {
                if (grid[row][line] == 1) {
                    queue.offer(new coordinate(row, line));
                }
                if (grid[row][line] == 0) {
                    peopleNum++;
                }

            }
        }
        if (peopleNum == 0) {
            return 0;
        }
        while (!queue.isEmpty()) {
            day++;
            int size = queue.size();
            while (size > 0) {
                coordinate cell = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = cell.x + direction[i][0], y = cell.y + direction[i][1];

                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                            || grid[x][y] == 2 || grid[x][y] == 1) {
                        continue;
                    }
                    grid[x][y] = 1;
                    queue.offer(new coordinate(x, y));
                    peopleNum--;
                    if (peopleNum == 0) {
                        return day;
                    }
                }
                size--;
            }
        }
        return -1;
    }
}
