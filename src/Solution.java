

import solution.Solution137;

import java.util.List;
import basicStructure.UndirectedGraphNode;


public class Solution {
    public static void main(String[] args) {
        Solution137 solution137 = new Solution137();

   //     int[] nums = {1,0,-1,-1,-1,-1,0,1,1,1};

        UndirectedGraphNode n1 = new UndirectedGraphNode(0);
        UndirectedGraphNode n2 = new UndirectedGraphNode(1);
        UndirectedGraphNode n3 = new UndirectedGraphNode(2);
        n1.neighbors.add(n1);
        n1.neighbors.add(n1);
        UndirectedGraphNode result = solution137.cloneGraph(n1);
       // solution137.deduplication(nums);
        System.out.println("result: " + result);
    //    System.out.println("nums:");
      //  for (int i = 0; i < nums.length; i++) {
      //      System.out.print("[" + i + "]:" + nums[i] + "  ");
      //  }

    }
}
