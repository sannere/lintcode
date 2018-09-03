package solution;

public class Solution608_2 {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] results = new int[2];
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            }
            else if (nums[left] + nums[right] < target) {
                left++;
            }
            else {
                results[0] = ++left;
                results[1] = ++right;
                break;
            }
        }
        return results;
    }
}
