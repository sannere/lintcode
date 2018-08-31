package solution;

public class Solution56_2 {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = 0, len = numbers.length;

        int[] results = {-1, -1};

        while (left < len) {
            right = left + 1;
            while (right < len && numbers[left] + numbers[right] != target) {
                right++;
            }
            if (right < len && numbers[left] + numbers[right] == target) {
                results[0] = left;
                results[1] = right;
                System.out.println(left + " " + right);
                return results;
            }
            left++;
        }
        return results;
    }
}
