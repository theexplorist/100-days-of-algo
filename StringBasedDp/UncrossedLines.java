class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        dp[0][0] = 0;
        
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        
        for(int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int c1 = dp[i - 1][j];
                    int c2 = dp[i][j - 1];
                    
                    dp[i][j] = Math.max(c1, c2);
                }
            }
        }
        
        return dp[n][m];
    }
}
