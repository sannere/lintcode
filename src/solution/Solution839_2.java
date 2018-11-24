package solution;

import basicStructure.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution839_2 {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        if (list1 == null || list1.size() == 0) {
            return list2;
        }
        if (list2 == null || list2.size() == 0) {
            return list1;
        }

        int i = 0, j = 0;
        List<Interval> results = new ArrayList<>();

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start < list2.get(j).start) {
                merge(results, list1.get(i++));
            }
            else {
                merge(results, list2.get(j++));
            }
        }
        while (i < list1.size()) {
            merge(results, list1.get(i++));
        }
        while (j < list2.size()) {
            merge(results, list2.get(j++));
        }

        return results;
    }
    private void merge(List<Interval> results, Interval interval) {
        if (results.isEmpty()) {
            results.add(interval);
            return;
        }

        Interval last = results.get(results.size() - 1);

        if (interval.start <= last.end) {
            last.end = Math.max(interval.end, last.end);
        }
        else {
            results.add(interval);
        }
    }
}
