package solution;

import basicStructure.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution577 {
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        if (intervals == null) {
            return new ArrayList<>();
        }

        return merge(intervals, 0, intervals.size() - 1);
    }
    private List<Interval> merge(List<List<Interval>> intervals, int start, int end) {
        if (start == end) {
            return intervals.get(start);
        }
        int mid = (start + end) / 2;

        List<Interval> left = merge(intervals, start, mid);
        List<Interval> right = merge(intervals, mid + 1, end);

        return mergeTwoList(left, right);
    }
    private List<Interval> mergeTwoList(List<Interval> left, List<Interval> right) {
        List<Interval> merged = new ArrayList<>();
        int l = 0, r = 0;
        while (l < left.size() && r < right.size()) {
            if (left.get(l).start < right.get(r).start) {
                mergeIntervals(merged, left.get(l));
                l++;
            }
            else {
                mergeIntervals(merged, right.get(r));
                r++;
            }
        }
        while (l < left.size()) {
            mergeIntervals(merged, left.get(l));
            l++;
        }
        while (r < right.size()) {
            mergeIntervals(merged, right.get(r));
            r++;
        }
        return merged;
    }
    private void mergeIntervals(List<Interval> merged, Interval interval) {
        if (merged.isEmpty()) {
            merged.add(interval);
            return;
        }
        Interval last = merged.get(merged.size() - 1);
        if (last.end >= interval.start) {
            last.end = Math.max(last.end, interval.end);
        }
        else {
            merged.add(interval);
        }
    }

}
