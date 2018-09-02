

import solution.Solution5_2;


public class Solution {
    public static void main(String[] args) {
        Solution5_2 solution5_2 = new Solution5_2();

        int[] nums = {1,2,3,4,5,6,8,9,10,7};


        int result = solution5_2.kthLargestElement(2, nums);
        //solution5_2.sortIntegers2(nums);
        System.out.println("result: " + result);
      //  System.out.println("nums:");
      /*  for (int i = 0; i < nums.length; i++) {
            System.out.print("[" + i + "]:" + nums[i] + "  ");
        }
        */

    }
}
