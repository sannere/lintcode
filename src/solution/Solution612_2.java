package solution;

import basicStructure.Point;

import java.util.Arrays;

public class Solution612_2 {
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

        Arrays.sort(points,
                (a, b) ->
                {
                int diss = Long.compare(getDistance(origin, a), getDistance(origin, b));
                    diss = diss != 0 ? diss : a.x - b.x;
                    diss = diss != 0 ? diss : a.y - b.y;
                    return diss;
                });
        return Arrays.copyOfRange(points, 0, k);
    }
    private long getDistance(Point o, Point p) {
        int detaX = o.x - p.x;
        int detaY = o.y - p.y;
        return detaX * detaX + detaY * detaY;
    }
}
