class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 2) {
            return 0;
        }

        int res = 0;
        int[] dp = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if(i > 0 && s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 > 0 ? dp[i - 2] : 0 ) + 2;
                } else if(i > 1 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '('){
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}