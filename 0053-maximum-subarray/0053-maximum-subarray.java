class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0], maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(currentMax, maxSum);
        }
        return maxSum;
    }
}