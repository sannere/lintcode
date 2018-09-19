
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import basicStructure.ListNode;
import basicStructure.UndirectedGraphNode;
import solution.Solution624;




public class Solution {
    public static void main(String[] args) {
        Solution624 solution624 = new Solution624();

        /*创建图
        UndirectedGraphNode head = new UndirectedGraphNode(0);
        head.neighbors.add(head);
        head.neighbors.add(head);
        */

      //  /*有返回值
        HashSet<String> set = new HashSet();
        set.add("ab");


        int result = solution624.minLength("abaababab",set);
    //    */

        /*创建链表
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);

        * */

        //无返回值
        //  solution624.sortColors2(nums, 2);

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
