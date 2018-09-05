package solution;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution616 {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        ArrayList<Integer>[] nextCourses = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nextCourses[i] = new ArrayList();
        }

        //统计所有点的degree和nextCourses
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            nextCourses[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        //把所有in_degree为0的course（map不包含的course）放入queue,和set(set为已经休完所有先修课的课程）
        Queue<Integer> queue = new LinkedList();
        int[] order = new int[numCourses];
        int index = 0;
        for (int num = 0; num < numCourses; num++) {
            if (degree[num] == 0) {
                queue.add(num);
                order[index++] = num;
            }
        }
        //BFS
        while (!queue.isEmpty()) {
            int course = queue.poll();

            for (int nextid : nextCourses[course]) {
                degree[nextid]--;
                if (degree[nextid] == 0) {
                    queue.add(nextid);
                    order[index++] = nextid;
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }
}
