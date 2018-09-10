package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution605_2 {
    /**
     * @param org:  a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    //拓扑排序
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (org == null || seqs == null || seqs.length == 0) {
            return false;
        }
        int n = org.length;
        int[] indegree = new int[n + 1];
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        Queue<Integer> queue = new LinkedList();

        //初始化map
        for (int i : org) {
            map.put(i, new HashSet());
        }
        //get indegree & edges
        boolean EmptySeq = false;
        for (int[] seq : seqs) {
            if (seq.length == 0) {
                EmptySeq = true;
                break;
            }
            if (seq[0] > n || seq[0] <= 0) {
                return false;
            }
            for (int i = 1; i < seq.length; i++) {
                int cur = seq[i];
                int pre = seq[i - 1];
                if (cur > n || cur <= 0) {
                    return false;
                }
                if (map.get(pre).add(cur)) {
                    indegree[cur]++;
                }
            }
        }

        if (EmptySeq) {
            return n == 0 ? true : false;
        }
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int orgIndex = 0;
        while (queue.size() == 1) {
            int cur = queue.poll();
            if (cur != org[orgIndex]) {
                return false;
            }
            for (int next : map.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
            orgIndex++;
        }

        return orgIndex == n;
    }
}
