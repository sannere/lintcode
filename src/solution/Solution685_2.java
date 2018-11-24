package solution;

import basicStructure.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution685_2 {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    private ListNode dummy, tail;
    private Map<Integer, ListNode> map;
    private Set<Integer> set;

    public int firstUniqueNumber(int[] nums, int number) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        dataStream();

        for (int i : nums) {
            addNum(i);
            if (i == number) {
                break;
            }
        }

        if (dummy.next == null || !set.contains(number)) {
            return -1;
        }
        return dummy.next.val;
    }
    private void dataStream() {
        dummy = new ListNode(-1);
        tail = dummy;
        map = new HashMap<>();
        set = new HashSet<>();
    }
    private void addNum (int num) {
        if (set.contains(num)) {
             if (map.containsKey(num)) {
                 deletNum(num);
             }
             return;
        }

        ListNode node = new ListNode(num);
        tail.next = node;
        map.put(num, tail);
        tail = node;
        set.add(num);
    }
    private void deletNum(int num) {
        ListNode pre = map.get(num);
        ListNode cur = pre.next;

        pre.next = cur.next;

        if (cur != tail) {
            map.put(cur.next.val, pre);
        }
        else {
            tail = pre;
        }
        map.remove(num);
    }
}
