package solution;

import java.util.Arrays;

public class Solution548 {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] temp = new int[nums1.length];
        int index = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] > nums2[j]) {
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            temp[index++] = nums1[i++];
            j++;
        }

        return Arrays.copyOfRange(temp, 0, index);
    }
}
