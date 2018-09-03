package solution;

import basicStructure.UndirectedGraphNode;

import java.util.*;

public class Solution137_2 {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }


        //1.reverse the map, put all the nodes in arraylist, then copy each nodes
        ArrayList<UndirectedGraphNode> list = bfs(node);

        //2.copy nodes
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        for (UndirectedGraphNode listNode : list) {
            map.put(listNode, new UndirectedGraphNode(listNode.label));
        }

        //3.copy edges(neighbor)
        for (UndirectedGraphNode listNode : list) {
            for (UndirectedGraphNode neighbor : listNode.neighbors) {
                UndirectedGraphNode copyNeighbor = map.get(neighbor);
                map.get(listNode).neighbors.add(copyNeighbor);
            }

        }

        return map.get(node);

    }
    private ArrayList<UndirectedGraphNode> bfs(UndirectedGraphNode head) {
        Queue<UndirectedGraphNode> queue = new LinkedList();
        Set<UndirectedGraphNode> set = new HashSet();

        set.add(head);
        queue.offer(head);

        while (!queue.isEmpty()) {
            UndirectedGraphNode qNode = queue.poll();
            for (UndirectedGraphNode neighbor : qNode.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }

        }

        return new ArrayList<>(set);
    }
}
