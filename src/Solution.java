
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import basicStructure.UndirectedGraphNode;
import solution.Solution382;




public class Solution {
    public static void main(String[] args) {
        Solution382 solution382 = new Solution382();

        /*创建图
        UndirectedGraphNode head = new UndirectedGraphNode(0);
        head.neighbors.add(head);
        head.neighbors.add(head);
        */

        //有返回值
        int nums[] = {8990,3146,9568,3889,7253,7395,10032,6179,1299,8738,1315,1280,830,6593};
        int result = solution382.triangleCount(nums);

        //无返回值
        //  solution382.sortColors2(nums, 2);

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
