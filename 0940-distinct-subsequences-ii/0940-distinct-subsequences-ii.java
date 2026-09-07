class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();

        // dp[i] = distinct subsequences of first i characters,
        // including the empty subsequence.
        long[] dp = new long[n + 1];

        dp[0] = 1;

        // last[c] = position of the previous occurrence of c
        // Position is 1-indexed.
        int[] last = new int[26];

        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';

            dp[i] = (2 * dp[i - 1]) % MOD;

            if (last[c] != 0) {
                dp[i] = (dp[i] - dp[last[c] - 1] + MOD) % MOD;
            }

            last[c] = i;
        }

        // Remove the empty subsequence.
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}