package solution;

public class Solution539 {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int i = 0, j = 0;



        while (j < nums.length) {
            while (j < nums.length && nums[j] == 0) {
                j++;
            }

            if (j < nums.length && i < j) {
                nums[i] = nums[j];
            }
            i++;
            j++;
        }
        while (i < nums.length) {
            nums[i] = 0;
        }
    }
}
