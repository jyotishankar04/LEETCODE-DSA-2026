class Solution {
    public int gcd(int m , int n){
        if(n == 0) return m;
        return gcd(n, m % n);
    }
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0], nums[nums.length - 1]);
    }
}