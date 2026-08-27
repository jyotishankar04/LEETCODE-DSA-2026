class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int count = 0;
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        while(count < first.length() 
        && count < last.length() 
        && first.charAt(count) == last.charAt(count)){
            count++;
        }
        return strs[0].substring(0, count);
    }
}