package solution;

import java.util.*;

class Course {
    int id,degree;
    ArrayList<Integer> nextCourses;
    Course(int n) {
        this.id = n;
        this.degree = 0;
        nextCourses = new ArrayList();
    }
}

public class Solution615 {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }

        //统计所有点的degree和nextCourses,把图上有的点放到map中
        HashMap<Integer, Course> map = new HashMap();
        for (int i = 0; i < prerequisites.length; i++) {
            newCourse(map, prerequisites[i]);
        }

        //把所有in_degree为0的course（map不包含的course）放入queue,和set(set为已经休完所有先修课的课程）
        Queue<Integer> queue = new LinkedList();
        HashSet<Integer> set = new HashSet();
        for (int num = 0; num < numCourses; num++) {
            if (map.containsKey(num) && map.get(num).degree == 0) {
                queue.offer(num);
                set.add(num);
            }
        }
        //BFS
        while (!queue.isEmpty()) {
            int course = queue.poll();

            for (int nextid : map.get(course).nextCourses) {
                Course next = map.get(nextid);
                next.degree--;
                if (next.degree == 0) {
                    queue.add(nextid);
                    set.add(nextid);
                }
            }
        }

        if (set.size() == map.size()) {
            return true;
        }
        return false;
    }
    private void newCourse(HashMap<Integer, Course> map, int[] pre) {
        if (!map.containsKey(pre[0])) {
            map.put(pre[0], new Course(pre[0]));
        }
        if (!map.containsKey(pre[1])) {
            map.put(pre[1], new Course(pre[1]));
        }
        map.get(pre[0]).degree++;
        map.get(pre[1]).nextCourses.add(pre[0]);
    }
}
