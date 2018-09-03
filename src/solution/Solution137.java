package solution;

import basicStructure.UndirectedGraphNode;

import java.util.HashMap;
import java.util.HashSet;

public class Solution137 {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */

    private HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node, copyNode);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbor));
        }

        return copyNode;
    }
}
