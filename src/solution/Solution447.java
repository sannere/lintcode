package solution;

import java.util.ArrayList;

public class Solution447 {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */

    public int searchBigSortedArray(ArrayList<Integer> reader, int target) {
        if (reader == null ) {
            return -1;
        }
        int start = 0, end = target;
        while (end < target) {
            start = end;
            end *= 2;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (reader.get(mid) == target) {
                return mid;
            }
            else if (reader.get(mid) < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }

        return -1;

    }
}
