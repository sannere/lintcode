package solution;


import basicStructure.Point;

import java.util.PriorityQueue;

public class Solution612 {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */

    public Point[] kClosest(Point[] points, Point origin, int k) {
        if (points == null || points.length == 0 || k == 0) {
            return new Point[0];
        }

        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k,
                (a, b) ->
                {
                    int diss = Long.compare(getDistance(origin, b), getDistance(origin, a));
                    diss = diss != 0 ? diss : b.x - a.x;
                    diss = diss != 0 ? diss : b.y - a.y;
                    return diss;
                });

        for (Point p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        Point[] result = new Point[k];

        while (k > 0) {
            result[--k] = maxHeap.poll();
        }

        return result;
    }
    private long getDistance(Point o, Point p) {
        int detaX = o.x - p.x;
        int detaY = o.y - p.y;
        return detaX * detaX + detaY * detaY;
    }

}
