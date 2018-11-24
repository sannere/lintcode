package dataStructure;

class NumArray {

    int[] nums;
    int[] prefixSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        getPrefixSum();
    }
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        for (int index = i + 1; index < prefixSum.length; index++) {
            prefixSum[index] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }
    private void getPrefixSum() {
        prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }
}
