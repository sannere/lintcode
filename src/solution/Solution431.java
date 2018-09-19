package solution;

import basicStructure.UndirectedGraphNode;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.*;

public class Solution431 {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        List<List<Integer>> results = new ArrayList();
        if (nodes == null) {
            return results;
        }
        if (nodes.size() == 0) {
            results.add(new ArrayList());
            return results;
        }

        HashSet<UndirectedGraphNode> set = new HashSet();
        for (UndirectedGraphNode node : nodes) {
            if (set.contains(node)) {
                continue;
            }
            bfs(node, nodes, set, results);
        }
        return results;
    }
    private void bfs(UndirectedGraphNode node, List<UndirectedGraphNode> nodes,
                     HashSet<UndirectedGraphNode> set, List<List<Integer>> results) {
        List<Integer> list = new ArrayList();

        Queue<UndirectedGraphNode> queue = new LinkedList();
        set.add(node);
        queue.offer(node);
        list.add(node.label);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (set.contains(neighbor)) {
                    continue;
                }
                set.add(neighbor);
                queue.offer(neighbor);
                list.add(neighbor.label);
            }
        }
        Collections.sort(list);
        results.add(list);
    }
}
