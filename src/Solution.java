
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import basicStructure.ListNode;
import basicStructure.TreeNode;
import basicStructure.UndirectedGraphNode;
import basicStructure.Interval;
import solution.Solution665;




public class Solution {
    public static void main(String[] args) {
        Solution665 solution665 = new Solution665();

        /*创建图
        UndirectedGraphNode head = new UndirectedGraphNode(0);
        head.neighbors.add(head);
        head.neighbors.add(head);
        */

        /*创建树
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(-2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(2);
        root.left = node2;
        node2.left = node3;
        node3.left = node4;
        */

       // /*有返回值

        List<String> list = new ArrayList<>();
        list.add("abat");
        list.add("baba");
        list.add("atan");
        list.add("atal");
        String[] arr = {"abat","baba","atan","atal"};
        int[][] nums = {{1,10},{3},{4,7}};

        Interval inter1 = new Interval(2,4);
        Interval inter2 = new Interval(12,17);

        Interval inter3 = new Interval(3,16);
        Interval inter4 = new Interval(17,20);

        List<Interval> list1 = new ArrayList<>();
        List<Interval> list2 = new ArrayList<>();

        list1.add(inter1);
        list1.add(inter2);
        list2.add(inter3);
        list2.add(inter4);
        int[][] nums1 = {{11,23,11,19,8,15,7,18,9}};
        int[] nums2 = {2,3,4,5};

        solution665.getNumMatrixSum(nums1);

   //     */

        /*创建链表
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);

        * */

        //无返回值
        //  solution665.sortColors2(nums, 2);

        //打印一个值
       // System.out.println("result: " + result);


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

        /*打印链表
        System.out.println("[");
        for (List<Integer> list : result) {
            System.out.print("[");
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println("],");
        }
        System.out.print("]");
        */

    }
}
