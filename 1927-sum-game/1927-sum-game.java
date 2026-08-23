class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftQ = 0, rightQ = 0;
        int leftSum = 0, rightSum = 0;

        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                leftQ++;
            } else {
                leftSum += c - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                rightQ++;
            } else {
                rightSum += c - '0';
            }
        }

        // Odd number of '?' -> Alice can always force inequality
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        // Bob can force equality only in this exact case
        return leftSum - rightSum != 9 * (rightQ - leftQ) / 2;
    }
}
