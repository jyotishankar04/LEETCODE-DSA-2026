class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int[] freq = new int[3]; // a -> 0, b -> 1, c -> 2
        int left = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            freq[ch - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += n - right;

                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                left++;
            }
        }

        return count;
    }
}