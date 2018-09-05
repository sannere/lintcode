package solution;

import basicStructure.Point;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution611 {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[] directionX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] directionY = {2, -2, 2, -2, 1, -1, 1, -1};

        Queue<Point> queue = new LinkedList();
        int path = 0;

        queue.offer(source);
        grid[source.x][source.y] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;

            while (size > 0) {
                Point p = queue.poll();

                for (int i = 0; i < 8; i++) {
                    Point nextP = new Point(p.x + directionX[i], p.y + directionY[i]);
                    if (nextP.x == destination.x && nextP.y == destination.y) {
                        return path;
                    }
                    if (nextP.x >= 0 && nextP.y >= 0 && nextP.x < grid.length && nextP.y < grid[0].length
                            && !grid[nextP.x][nextP.y]) {
                        queue.offer(nextP);
                        grid[nextP.x][nextP.y] = true;
                    }
                }
                size--;
            }
        }
        return -1;
    }
}
