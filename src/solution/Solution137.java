package solution;

import basicStructure.UndirectedGraphNode;

import java.util.*;

public class Solution137 {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */

    private HashMap<Integer, UndirectedGraphNode> map = new HashMap();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        map.put(result.label, result);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            result.neighbors.add(cloneGraph(neighbor));
        }

        return result;
    }
}
