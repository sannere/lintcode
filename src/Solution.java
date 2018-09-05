

import basicStructure.UndirectedGraphNode;
import solution.Solution616;

import java.util.HashSet;
import java.util.Set;


public class Solution {
    public static void main(String[] args) {
        Solution616 solution616 = new Solution616();

        /*创建图
        UndirectedGraphNode head = new UndirectedGraphNode(0);
        head.neighbors.add(head);
        head.neighbors.add(head);
        */

        //有返回值
        int[][] pre = {{1,0}};
        int[] result = solution616.findOrder(2,pre);

        //无返回值
        //  solution616.sortColors2(nums, 2);

        //打印一个值
        System.out.println("result: " + result);


        /*打印数组
        System.out.println("nums:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print("[" + i + "]:" + nums[i] + "  ");
        }
        */
        /*打印图
        System.out.println("图：");
        System.out.println("head: " + result);
        for (UndirectedGraphNode neighbor: result.neighbors) {
            System.out.println("neighbors: " + neighbor);
        }
        */

    }
}
