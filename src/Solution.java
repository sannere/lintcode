

import solution.Solution464;

import java.util.List;
import basicStructure.UndirectedGraphNode;


public class Solution {
    public static void main(String[] args) {
        Solution464 solution464 = new Solution464();

        int[] nums = {3, 2, 1};


        //int[] result = solution464.twoSum7(numbers, -1);
        solution464.sortIntegers2(nums);
       // System.out.println(numbers[0] + " " + result[1]);
        System.out.println("nums:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print("[" + i + "]:" + nums[i] + "  ");
        }

    }
}
