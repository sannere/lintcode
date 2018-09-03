

import basicStructure.UndirectedGraphNode;
import solution.Solution137;


public class Solution {
    public static void main(String[] args) {
        Solution137 solution137 = new Solution137();

        UndirectedGraphNode head = new UndirectedGraphNode(0);
        head.neighbors.add(head);
        head.neighbors.add(head);

        //有返回值
        UndirectedGraphNode result = solution137.cloneGraph(head);

        //无返回值
        //  solution137.sortColors2(nums, 2);

        /*打印一个值
        System.out.println("result: " + result);
        */

        /*打印数组
        System.out.println("nums:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print("[" + i + "]:" + nums[i] + "  ");
        }
        */

        System.out.println("图：");
        System.out.println("head: " + result);
        for (UndirectedGraphNode neighbor: result.neighbors) {
            System.out.println("neighbors: " + neighbor);
        }

    }
}
