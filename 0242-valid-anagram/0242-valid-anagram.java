class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            hash.put(s.charAt(i),hash.getOrDefault(s.charAt(i), 0) + 1);
            hash.put(t.charAt(i),hash.getOrDefault(t.charAt(i), 0) - 1);
        }
        for(int i: hash.values()){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}