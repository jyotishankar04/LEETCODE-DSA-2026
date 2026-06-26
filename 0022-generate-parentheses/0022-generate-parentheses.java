class Solution {
    private void helper(int index, String s, int open, int close, List<String> ans, int n){
        if(open > n) return;
        if(open + close == (2 * n) && open == close ) {
            ans.add(s);
            return;
        }

        helper(index + 1, s + "(", open + 1, close, ans, n);
        if(open > close){
            helper(index + 1, s + ")", open, close + 1, ans, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        helper(0, "", 0,0,ans,n);
        return ans;
    }
}