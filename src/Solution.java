

import basicStructure.UndirectedGraphNode;
import solution.Solution135;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {
    public static void main(String[] args) {
        Solution135 solution135 = new Solution135();

        /*创建图
        UndirectedGraphNode head = new UndirectedGraphNode(0);
        head.neighbors.add(head);
        head.neighbors.add(head);
        */

        //有返回值
        int nums[] = {2,3,6,7};
        List<List<Integer>> result = solution135.combinationSum(nums, 7);

        //无返回值
        //  solution135.sortColors2(nums, 2);

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
