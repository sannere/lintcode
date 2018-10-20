package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution15_2 {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        boolean hasNext = true;
        if (nums == null || nums.length == 0) {
            results.add(new ArrayList());
            return results;
        }

        Arrays.sort(nums);

        while (hasNext) {
            ArrayList<Integer> permutation = new ArrayList();
            for (int i : nums) {
                permutation.add(i);
            }

            results.add(permutation);

            hasNext = getNext(nums);
        }
        return results;
    }
    private boolean getNext(int[] nums) {
       // boolean hasNext = false;
        int len = nums.length;
        int index = -1;

        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        for (int i = len - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, index, i);
                break;
            }
        }

        for (int i = index + 1, j = len - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        return true;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
