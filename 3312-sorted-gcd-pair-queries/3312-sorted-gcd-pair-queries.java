import java.util.*;

class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;

        for(int n : nums)
            max = Math.max(max, n);


        int[] freq = new int[max + 1];

        for(int n : nums)
            freq[n]++;


        long[] gcdCount = new long[max + 1];


        // Count pairs having gcd >= g
        for(int g = 1; g <= max; g++){

            long count = 0;

            for(int multiple = g; multiple <= max; multiple += g){
                count += freq[multiple];
            }


            gcdCount[g] = count * (count - 1) / 2;
        }


        // Remove larger gcd multiples
        for(int g = max; g >= 1; g--){

            for(int multiple = 2*g; multiple <= max; multiple += g){

                gcdCount[g] -= gcdCount[multiple];

            }
        }


        // Prefix sum
        for(int i = 1; i <= max; i++){

            gcdCount[i] += gcdCount[i-1];

        }


        int[] ans = new int[queries.length];


        for(int i = 0; i < queries.length; i++){

            long q = queries[i];


            int left = 1;
            int right = max;


            while(left < right){

                int mid = left + (right-left)/2;


                if(gcdCount[mid] > q)
                    right = mid;
                else
                    left = mid + 1;
            }


            ans[i] = left;
        }


        return ans;
    }
}