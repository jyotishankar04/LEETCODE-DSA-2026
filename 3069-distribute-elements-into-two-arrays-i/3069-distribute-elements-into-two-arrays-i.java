class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        if(n <= 2) return nums;
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        result.add(nums[0]);
        temp.add(nums[1]);
        for(int i = 2; i < n; i++){
            if(result.get(result.size() - 1) >= temp.get(temp.size() - 1)){
                result.add(nums[i]);
            }else{
                temp.add(nums[i]);
            }
        }

        for(int i : temp){
            result.add(i);
        }

        int r[] = new int[n];
        for(int i = 0; i < n ; i++){
            r[i] = result.get(i);
        }
        return r;
    }
}