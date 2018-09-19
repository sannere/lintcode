import basicStructure.UndirectedGraphNode;

import java.util.*;

public class Solution618 {
    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        if (graph == null || graph.isEmpty() || node == null || !values.containsValue(target)) {
            return null;
        }
        if (values.get(node) == target) {
            return node;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList();
        HashSet<UndirectedGraphNode> set = new HashSet();

        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (set.contains(neighbor)) {
                    continue;
                }
                if (values.get(neighbor) == target) {
                    return neighbor;
                }
                set.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return null;
    }
}
