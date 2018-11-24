package solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Coordinate {
    int x,y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
public class Solution793_2 {
    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     */
    public int intersectionOfArrays(int[][] arrs) {
        if (arrs == null || arrs.length == 0) {
            return 0;
        }

        Comparator<Coordinate> comparate = new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return arrs[o1.x][o1.y] - arrs[o2.x][o2.y];
            }
        };
        PriorityQueue<Coordinate> pq = new PriorityQueue<>(arrs.length, comparate);

        //给每个一维数组排序，并把最小的数字（每个数组的第一个元素）坐标加入pq
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i].length == 0) {
                return 0;
            }

            Arrays.sort(arrs[i]);
            pq.offer(new Coordinate(i, 0));
        }

        int result = 0, count = 0, last = 0;

        while (!pq.isEmpty()) {
            Coordinate coor = pq.poll();
            if (arrs[coor.x][coor.y] != last || count == 0) {
                if (count == arrs.length) {
                    result++;
                }
                count = 1;
                last = arrs[coor.x][coor.y];
            }
            else {
                count++;
            }

            coor.y++;
            if (coor.y < arrs[coor.x].length) {
                pq.offer(coor);
            }
        }

        if (count == arrs.length) {
            result++;
        }

        return result;
    }
}
