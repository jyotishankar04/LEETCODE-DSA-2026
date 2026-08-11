class Solution {
    int linearSearch(int[] nums, int num){
        for(int i = 0; i < nums.length; i++){
            if(num == nums[i]){
                return i;
            }
        }
        return -1;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for(int i = 0 ; i < nums1.length; i++){
            int num = nums1[i];
            int presentIndex = linearSearch(nums2, num);
            nums1[i] = -1;
            for(int j =  presentIndex + 1; j < nums2.length; j++){
                if(num < nums2[j]){
                    nums1[i] = nums2[j];
                    break;
                }
            }
        }

        return nums1;
    }
}