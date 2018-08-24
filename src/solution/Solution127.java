package solution;

import basicStructure.DirectedGraphNode;

import javax.management.DescriptorRead;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution127 {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        //count in degrees of all node in graph

        if (graph == null) {
            return graph;
        }

        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                }
                else {
                    map.put(neighbor, 1);
                }
            }

        }
        //create a new ArrayList for topological nodes
        ArrayList<DirectedGraphNode> results = new ArrayList();

        //put all nodes that degree == 0( does'nt exists in map) in results and queue

        Queue<DirectedGraphNode> q = new LinkedList<>();
        for (DirectedGraphNode node: graph) {
            if(!map.containsKey(node)) {
                results.add(node);
                q.add(node);
            }
        }

        // poll one node in queue and map it's neighbors.
        // Every neighbors node's degree minus 1，and if any node's degree == 0, put it in the q and add to results
        //if q if empty then the graph is topologigal, and return results


        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    q.add(neighbor);
                    results.add(neighbor);
                }
            }
        }

        return results;
    }
}
