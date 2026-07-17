class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        int left = 0;
        long ans  = 1;
        Arrays.sort(nums);
        for(int right = 0; right < n; right++){
            sum+= nums[right];
            while(nums[right] * (right - left + 1L) > sum + k){
                sum -= nums[left];
                left++;
            }

            ans = Math.max(ans,right- left + 1L);
        }

        return (int)ans;
    }
}