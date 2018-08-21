package solution;

public class Solution539_2 {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int i = 0, j = 0, temp;

        while (j < nums.length) {
            if (nums[j] != 0) {
                if (i < j) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                i++;
            }
            j++;
        }
    }
}
