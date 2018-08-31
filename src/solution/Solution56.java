package solution;

import java.util.HashMap;

public class Solution56 {
    public int[] twoSum(int[] numbers, int target) {
        int[] results = {-1,-1};
        if (numbers == null || numbers.length == 0) {
            return results;
        }

        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                results[0] = map.get(target - numbers[i]);
                results[1] = i;
                System.out.println(results[0] + " " + results[1]);
                return results;
            }
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], i);
            }
        }

        return results;
    }
}
