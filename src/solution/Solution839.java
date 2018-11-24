package solution;

import basicStructure.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution839 {
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
        List<Interval> results = new ArrayList<>();
        merge(list1, list2, results);
        return results;
    }
    private void merge(List<Interval> list1,
                       List<Interval> list2,
                       List<Interval> results) {
        int index1 = 0, index2 = 0;
        while (index1 < list1.size() && index2 < list2.size()) {
            Interval inter;
            if (list1.get(index1).start < list2.get(index2).start) {
                inter = new Interval(list1.get(index1).start, list1.get(index1).end);
                index1++;
            }
            else {
                inter = new Interval(list2.get(index2).start, list2.get(index2).end);
                index2++;
            }

            while (index1 < list1.size() || index2 < list2.size()) {
                if (index1 < list1.size() && list1.get(index1).start <= inter.end) {
                    if (list1.get(index1).end < inter.end) {
                        index1++;
                    }
                    else {
                        inter.end = list1.get(index1++).end;
                    }
                    continue;
                }
                if (index2 < list2.size() && list2.get(index2).start <= inter.end) {
                    if (list2.get(index2).end < inter.end) {
                        index2++;
                    }
                    else {
                        inter.end = list2.get(index2++).end;
                    }
                    continue;
                }
                break;
            }
            results.add(inter);
        }

        while (index1 < list1.size()) {
            results.add(new Interval(list1.get(index1).start, list1.get(index1).end));
            index1++;
        }
        while (index2 < list2.size()) {
            results.add(new Interval(list2.get(index2).start, list2.get(index2).end));
            index2++;
        }
    }
}
