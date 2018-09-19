package solution;

import java.util.*;

public class Solution178 {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length > n - 1 || n == 0) {//the max of a tree's edges number is n - 1
            return false;
        }
        if (n == 1 && edges.length == 0 || edges.length == 1 && edges[0].length == 0) {
            return true;
        }

        List<Integer>[] neighbors = new ArrayList[n];//degree is the number of a node's edges
        for (int i = 0; i < n; i++) {
            neighbors[i] = new ArrayList();
        }

        //get degree and map
        int[] degree = new int[n];
        for (int[] edge : edges) {
            if (edge[0] == edge[1]) {
                return false;
            }
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }


        Queue<Integer> queue = new LinkedList();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {//a single node with no edges
                return false;
            }
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            n--;
            for (int neighbor : neighbors[node]) {
                degree[neighbor]--;
                if (degree[neighbor] == 1) {
                    queue.offer(neighbor);
                }
            }
        }
        return n == 0;
    }
}
