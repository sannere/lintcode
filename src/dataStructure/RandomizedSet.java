package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class RandomizedSet {
    List<Integer> list;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<>();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (list.contains(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int tail = list.size() - 1;
        if (index < tail) {
            map.put(list.get(tail), index);
            list.set(index, list.get(tail));
        }
        list.remove(tail);
        map.remove(val);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        int randomIndex = (int)(Math.random() * (list.size()));
        return list.get(randomIndex);
    }
}
