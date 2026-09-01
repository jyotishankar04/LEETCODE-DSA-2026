class Solution {
    public int[] twoSum(int[] nums, int target) {
        // //int[] arr = new arr[n];
        // int sum = 0;
        // for(int i = 0; i < nums.length; i++){
        //     sum = arr[i] + arr[i+1];
        // }
        // if(sum == target){
            
        // }
        int n= nums.length;
        for(int i = 0; i < n; i++){
            for(int j  = i + 1; j < n; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}