class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        // for(int i = 0; i < n; i++){
        //     int count = 0;
        //     Map<Character, Integer> hash = new HashMap<>();
        //     for(int j = i; j < n; j++){
        //         hash.put(s.charAt(j), hash.getOrDefault(s.charAt(j),0) + 1);
        //         if(hash.get(s.charAt(j)) > 2){
        //             break;
        //         }
        //         maxLen  = Math.max(maxLen, j - i + 1);
        //     }
        // }

        // Optimal
        int left = 0;
        int[] freq = new int[26];
        for(int right  = 0; right < n; right++){
            char ch = s.charAt(right);
            freq[ch - 'a']++;
            while(freq[ch - 'a'] > 2){
                freq[s.charAt(left) - 'a']--;                
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}