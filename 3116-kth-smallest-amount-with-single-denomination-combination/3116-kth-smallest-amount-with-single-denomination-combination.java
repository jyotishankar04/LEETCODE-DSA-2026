class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long lo = 1, hi = (long) k * coins[0];

        for (int c : coins)
            hi = Math.min(hi, (long) k * c);

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if (count(mid, coins) >= k)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    private long count(long x, int[] coins) {
        long ans = 0;
        int n = coins.length;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    long g = gcd(lcm, coins[i]);
                    lcm = lcm / g * coins[i];

                    if (lcm > x) {
                        lcm = x + 1;
                        break;
                    }
                }
            }

            if (bits % 2 == 1)
                ans += x / lcm;
            else
                ans -= x / lcm;
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}