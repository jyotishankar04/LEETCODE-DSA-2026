class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int it : nums){
            hash.add(it);
        }

        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1] + 1){
                sum+=nums[i];
            }else{
                break;
            }
        }

        while(hash.contains(sum)){
            sum++;
        }

        return sum;
    }
}