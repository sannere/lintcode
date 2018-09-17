package solution;

import java.util.Arrays;

public class Solution59_2 {
    public int threeSumClosest(int[] numbers, int target) {
        int result = numbers[0] + numbers[1] + numbers[2];
        int length = numbers.length;
        if (length == 3) {
            return result;
        }

        Arrays.sort(numbers);

        for (int start = 0; start < length - 2; start++) {
            int end = length - 1;
            int mid = length - 2;
            int sum = numbers[start] + numbers[mid] + numbers[end];
            if (start > 0 && numbers[start] == numbers[start - 1]) {
                continue;
            }

            if (sum < target) {
                result = sum;
                continue;
            }

            if (numbers[start] * 3 > target) {
                sum = numbers[start] + numbers[start + 1] + numbers[start + 2];
                return Math.abs(target - result) > sum - target ? sum : result;
            }

            int left = start + 1;
            int right = length - 1;

            while (left < right) {
                sum = numbers[left] + numbers[right] + numbers[start];
                if (sum < target) {
                    result = Math.abs(target - result) > Math.abs(target - sum) ? sum : result;
                    left++;
                }
                else if (sum > target) {
                    result = Math.abs(target - result) > Math.abs(sum - target) ? sum : result;
                    right--;
                }
                else {
                    return target;
                }
            }
        }
        return result;
    }
}
