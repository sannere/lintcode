package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution547_2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int last = nums1[0] - 1;
        int index = 0;
        for (int n1 : nums1) {
            if (last == n1) {
                continue;
            }
            while (index < nums2.length) {
                if (nums2[index] > n1) {
                    break;
                }
                if (nums2[index] == n1) {
                    index++;
                    list.add(n1);
                    break;
                }
                index++;
            }
            last = n1;
        }
        int[] result = new int[list.size()];
        index = 0;
        for (int i : list) {
            result[index++] = i;
        }

        return result;
    }
}
