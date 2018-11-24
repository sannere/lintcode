package solution;

import java.util.HashSet;
import java.util.Set;

public class Solution547 {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                resultSet.add(i);
            }
        }

        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int i : resultSet) {
            result[index++] = i;
        }

        return result;
    }
}
