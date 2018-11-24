package dataStructure;

import java.util.HashMap;
import java.util.Map;



public class LRUCache {
    class ListNode{
        int key,val;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    private int capacity,size;
    private  Map<Integer, ListNode> map = new HashMap<>();
    private ListNode dummy, tail;

    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        dummy = new ListNode(0,0);
        tail = dummy;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            moveToTail(key);
            return tail.val;
        }
        return -1;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            moveToTail(key);
            if (value != tail.val) {
                tail.val = value;
            }
            return;
        }
        if (size < capacity) {
            tail.next = new ListNode(key, value);
            map.put(key, tail);
            tail = tail.next;
            size++;
            return;
        }

        ListNode toBeDelet = dummy.next;
        dummy.next = toBeDelet.next;

        if (dummy.next!= null) {
            map.put(dummy.next.key, dummy);
        }

        map.remove(toBeDelet.key);
        size--;
        set(key, value);
    }

    private void moveToTail(int key) {
        ListNode pre = map.get(key);
        ListNode cur = pre.next;
        ListNode next = cur.next;

        if (next == null) {
            return;
        }

        pre.next = next;
        tail.next = cur;

        map.put(next.key, pre);

        cur.next = null;
        map.put(cur.key, tail);

        tail = cur;
    }
}
