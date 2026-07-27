class Solution {
    public int maxProduct(int[] nums) {
        int maxi = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int current = (nums[i] - 1) * (nums[j] - 1);
                if(current > maxi){
                    maxi = current; 
                }
            }
        }   
        return maxi;
    }
}