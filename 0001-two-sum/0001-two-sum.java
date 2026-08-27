class Solution {

    // Brute
    // public int[] twoSum(int[] nums, int target) {
    //     int n = nums.length;
    //     int[] result = new int[2];
    //     for(int i = 0; i < n; i++){
    //         for(int j = i + 1; j < n; j++){
    //             if(nums[i] + nums[j] == target) {
    //                 result[0] = i;
    //                 result[1] = j;
    //                 return result;
    //             }
    //         }
    //     }


    //     return new int[]{-1,-1};
    // }



    // Better
    // public int[] twoSum(int[] nums, int target) {
    //     int n = nums.length;
    //     int[] result = new int[2];
        
    //     Map<Integer, Integer> temp = new HashMap<>();

    //     for(int i = 0; i < n; i ++){
    //         temp.put(nums[i], i);
    //     }

    //     for(int i = 0; i < n; i++){
    //         int num = nums[i];
    //         int moreNeeded = target - nums[i];

    //         if(temp.containsKey(moreNeeded) && temp.get(moreNeeded) != i){
    //             return new int[]{i,temp.get(moreNeeded)};
    //         }
    //     }


    //     return new int[]{-1,-1};
    // }

    

    // Optimal
    // public int[] twoSum(int[] nums, int target) {
    //     int n = nums.length;
    //     int[] result = new int[2];
    //     int[][] hash = new int[n][2];
    //     for(int i = 0; i < n; i++){
    //         hash[i][0] = nums[i];
    //         hash[i][1] = i;
    //     }
    //     Arrays.sort(hash, (a, b) -> Integer.compare(a[0], b[0]));
    //     int left = 0, right = n - 1;

    //     while(left < right){
    //         int sum = hash[left][0] + hash[right][0];
    //         if(sum == target){
    //             return new int[]{hash[left][1], hash[right][1]};
    //         }else if(sum > target){
    //             right--;
    //         }else{
    //             left++;
    //         }
    //     }


    //     return new int[]{-1,-1};
    // }

     public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < n; i++){
            int num = nums[i];
            int moreNeeded = target- num;
            if(hash.containsKey(moreNeeded)){
                return new int[]{i, hash.get(moreNeeded)};
            } 
            hash.put(num, i);
        }
        return new int[]{-1, -1};
    
    }

}