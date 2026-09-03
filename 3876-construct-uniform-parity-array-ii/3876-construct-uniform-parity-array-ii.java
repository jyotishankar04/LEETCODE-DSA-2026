class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean allEven = true;
        boolean allOdd = true;

        int min = nums1[0];

        for (int num : nums1) {
            min = Math.min(min, num);

            if (num % 2 == 0) {
                allOdd = false;
            } else {
                allEven = false;
            }
        }

        // Already uniform
        if (allEven || allOdd) {
            return true;
        }

        // Minimum is odd -> convert every even number to odd
        return min % 2 == 1;
    }
}