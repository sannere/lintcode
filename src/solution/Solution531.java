package solution;

import basicStructure.UndirectedGraphNode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution531 {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (graph == null || graph.size() == 0) {
            return -1;
        }
        if (s.equals(t)) {
            return 0;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList();
        HashMap<UndirectedGraphNode, Integer> map = new HashMap();

        queue.offer(s);
        map.put(s, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                UndirectedGraphNode node = queue.poll();
                for (UndirectedGraphNode neighbor : node.neighbors) {
                    if (neighbor.equals(t)) {
                        return map.get(node) + 1;
                    }
                    if (map.containsKey(neighbor)) {
                        continue;
                    }
                    map.put(neighbor, map.get(node) + 1);
                    queue.offer(neighbor);
                }
                size--;
            }
        }
        return -1;
    }
}
