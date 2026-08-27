class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];

        int matched = 0;

        // Match target from left to right
        while (matched < n) {

            int t = target.charAt(matched) - 'a';

            if (freq[t] == 0) {
                break;
            }

            ans[matched] = target.charAt(matched);
            freq[t]--;

            matched++;
        }

        /*
         * If we couldn't match the target completely,
         * first try to make the answer greater at the
         * position where matching failed.
         */
        if (matched < n) {

            int t = target.charAt(matched) - 'a';

            // Find smallest character > target[matched]
            for (int c = t + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    ans[matched] = (char) ('a' + c);
                    freq[c]--;

                    return build(ans, matched + 1, freq);
                }
            }
        }

        /*
         * Either:
         * 1. We matched the whole target, or
         * 2. We couldn't make the mismatch position greater.
         *
         * So backtrack through the positions that were
         * actually matched.
         */
        for (int i = matched - 1; i >= 0; i--) {

            // Restore the character used at position i
            int current = target.charAt(i) - 'a';
            freq[current]++;

            int t = target.charAt(i) - 'a';

            // Find smallest character > target[i]
            for (int c = t + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    ans[i] = (char) ('a' + c);
                    freq[c]--;

                    return build(ans, i + 1, freq);
                }
            }
        }

        return "";
    }

    private String build(char[] ans, int pos, int[] freq) {

        // Put remaining characters in sorted order
        for (int c = 0; c < 26; c++) {

            while (freq[c] > 0) {
                ans[pos++] = (char) ('a' + c);
                freq[c]--;
            }
        }

        return new String(ans);
    }
}