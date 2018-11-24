package solution;

import java.util.Arrays;

public class Solution547_3 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        int[] temp = new int[nums1.length];

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }
            if (nums1[i] == nums2[j]) {
                temp[index++] = nums1[i++];
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            j++;
        }

        return Arrays.copyOfRange(temp, 0, index);
    }
}
