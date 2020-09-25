class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return lps(s, 0, s.length() - 1, dp);
    }
    
    private int lps(String s, int si, int ei, int[][] dp) {
        
        if(si > ei) {
            return 0;
        }
        
        if(si == ei) {
            return 1;
        }
        
        if(dp[si][ei] != -1) {
            return dp[si][ei];
        }
        
        if(s.charAt(si) == s.charAt(ei)) {
            return 2 + lps(s, si + 1, ei - 1, dp);
        }
        
        int c1 = lps(s, si + 1, ei, dp);
        int c2 = lps(s, si, ei - 1, dp);
        
        return dp[si][ei] = Math.max(c1, c2);
    }
}
