package solution;

public class Solution196 {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */

    public int findMissing(int[] nums) {
        int missing = nums.length;

        for (int index = 0; index < nums.length; ) {
            if (nums[index] == nums.length) {
                missing = index;
                index++;
                continue;
            }
            if (nums[index] == index) {
                index++;
                continue;
            }
            int temp = nums[nums[index]];
            nums[nums[index]] = nums[index];
            nums[index] = temp;
        }
        return missing;
    }
}
