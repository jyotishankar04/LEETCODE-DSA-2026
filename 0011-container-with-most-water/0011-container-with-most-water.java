class Solution {
    public int maxArea(int[] height) {
        // int n = height.length;
        // int maxWater = 0;

        // for(int i = 0; i < n; i++){
        //     int max = 0;
        //     for(int j = i + 1; j < n; j++){
        //         max = (j - i) * Math.min(height[i], height[j]);
        //     }
        //     maxWater = Math.max(max, maxWater);
        //     System.out.println("OUter " +  max + " " + maxWater);
        // }
        // return maxWater;



        int left = 0;
        int right = height.length-1;
        int maxWater = 0;
        while(left < right){
            int width = right - left;
            int area = width * Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, area);
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxWater;
    }
}