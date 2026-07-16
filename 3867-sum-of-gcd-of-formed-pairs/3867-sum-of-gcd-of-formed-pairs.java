class Solution {
    public long GCD(long n, long m){
        if(m == 0) return n;

        return GCD(m, n % m);
    }
    public long gcdSum(int[] nums) {
         int n = nums.length;
         long maxTillNow = nums[0];
         long[] prefixGcd = new long[n];
         for(int i = 0; i < n; i++){
            maxTillNow = Math.max(nums[i], maxTillNow);
            prefixGcd[i] = GCD(nums[i], maxTillNow);
         }
         Arrays.sort(prefixGcd);
         long sum = 0;
         for(int i = 0; i < n / 2; i++){
            sum += GCD(prefixGcd[i], prefixGcd[n - 1 -i]);
         }
         return sum;
    }
}