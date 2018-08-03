package solution;

public class Solution891_2 {
    /**
     * @param s: a string
     * @return: nothing
     */
    public boolean validPalindrome(String s) {
        int result = Myfunction(s.toCharArray(), 0, s.length() - 1, 0);
        return result == 0 || result == 1;
    }
    private int Myfunction(char[] arr, int left, int right, int delete) {
        if (delete == 2) {
            return -1;
        }

        while (left <= right && arr[left] == arr[right]) {
            left++;
            right--;
        }

        if (left > right) {
            return 0;
        }
        else {
            int situationA = Myfunction(arr, left + 1, right, delete + 1);
            int situationB = Myfunction(arr, left, right - 1, delete + 1);
            return situationA == 0 || situationB == 0 ? 1 : -1;
        }
    }
}
