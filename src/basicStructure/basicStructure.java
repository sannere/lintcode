package basicStructure;

import java.util.ArrayList;

public class basicStructure {
    class DirectedGraphNode {
        public int label;
        public ArrayList<DirectedGraphNode> neighbors;
        public DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }
}
