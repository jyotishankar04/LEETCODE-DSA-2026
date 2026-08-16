class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] count = new int[3];

        for (int stone : stones) {
            count[stone % 3]++;
        }

        int zero = count[0];
        int one = count[1];
        int two = count[2];

        // No stones with remainder 1 or 2
        if (one == 0 && two == 0) {
            return false;
        }

        // If zero stones are odd
        if (zero % 2 == 1) {
            return Math.abs(one - two) > 2;
        }

        // If zero stones are even
        return one > 0 && two > 0;
    }
}