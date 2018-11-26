package solution;

import java.util.*;

public class Solution603 {
    /*
     * @param nums: a set of distinct positive integers
     * @return: the largest subset
     */
    List<Integer> result;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            map.put(nums[i], 1);
            helper(nums, map, i + 1, list);
            list.remove(0);
        }

        return result;
    }
    private void helper(int[] nums,
                        Map<Integer, Integer> map,
                        int index,
                        List<Integer> list) {
        int last = list.get(list.size() - 1);
        int lastNum = map.get(last);

        for (int i = index; i < nums.length; i++) {
            if (nums[i] % last != 0) {
                continue;
            }
            if (map.containsKey(nums[i]) && map.get(nums[i]) >= lastNum + 1) {
                continue;
            }

            map.put(nums[i], lastNum + 1);
            list.add(nums[i]);
            helper(nums, map, i + 1, list);
            list.remove(list.size() - 1);
        }

        if (list.size() > result.size()) {
            result = new ArrayList(list);
        }
    }
}
