package solution;

public class Solution5_answer {
    public int kthLargestElement(int k, int[] nums) {

        // write your code here
        int start = 0, end = nums.length -1;
        int print = 0;
        while(start <= end){
           // int pivot = nums[end];
            int index = start-1;
            for(int i = start; i < end; i++){
                if(nums[i] > nums[end]){
                    swap(nums, i, ++index);
                }
            }

            swap(nums, ++index, end);//确定了第index位置的number, index左侧为所有比它大的数，右侧为比它小的

            if(index == k - 1){//the kth number(k - 1), is just == pivot, find it
                return nums[index];
            }
            if(index < k -1){//the kth number < pivot, select from pivot's right side
                start = index + 1;
            }else{//the kth number > pivot, select from pivot's left side
                end = index - 1;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
