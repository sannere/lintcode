package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution607_2 {
    public class TwoSum {
        /*
         * @param number: An integer
         * @return: nothing
         */

        private List<Integer> list = new ArrayList();


        public void add(int number) {
            // write your code here
            list.add(number);

        }

        /*
         * @param value: An integer
         * @return: Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            Collections.sort(list);

            for (int start = 0, end = list.size() - 1; start < end;) {
                if (list.get(start) + list.get(end) == value) {
                    return true;
                }
                else if (list.get(start) + list.get(end) > value) {
                    end--;
                }
                else {
                    start++;
                }
            }
            return false;
        }
    }
}
