class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        int n = nums.length;
        int j = -1;
        int ans =0;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            hash.put(num, hash.getOrDefault(num,0) + 1);
            while(hash.get(num) > k){
                j ++;
                hash.put(nums[j], hash.get(nums[j]) - 1);
            }
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
}