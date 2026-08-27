class Solution {

    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int count = 0;

        while (count < first.length() &&
               count < last.length() &&
               first.charAt(count) == last.charAt(count)) {

            count++;
        }

        return first.substring(0, count);
    }
}