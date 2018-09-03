package solution;

public class Solution143 {
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        quickSort(colors, 0, colors.length - 1);
    }
    private void quickSort(int[] colors, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int pivot = colors[(end + start) / 2];
        while (left <= right) {
            while (left <= right && colors[left] < pivot) {
                left++;
            }
            while (left <= right && colors[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(colors, start, right);
        quickSort(colors, left, end);
    }
}
