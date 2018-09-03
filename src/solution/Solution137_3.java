package solution;

import basicStructure.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution137_3 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        //遍历原图，复制所有的点
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap();
        ArrayList<UndirectedGraphNode> queue = new ArrayList<>();
        int index = 0;

        queue.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        while (queue.size() > index) {
            UndirectedGraphNode head = queue.get(index);
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!queue.contains(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);//放原图的node而不是new出来的新节点
                    // 因为下面遍历找neighbor时需要用到queue，而新节点还没有neighbor的信息
                }
            }
            index++;
        }

        //复制neighbor
        for (UndirectedGraphNode head : queue) {
            for (UndirectedGraphNode neighbor : head.neighbors) {
                map.get(head).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}
