//Recursive
Time Complexity - O(3 ^ n)
Space Complexity - O(n + m) recursive stack space
class Solution {
    public int minDistance(String word1, String word2) {
        
        return minDistance(word1, word2, word1.length(), word2.length());
    }
    
    private int minDistance(String word1, String word2, int n, int m) {
        
        if(n == 0 && m == 0) {
            return 0;
        }
        
        if(n == 0) {
            return m;
        }
        
        if(m == 0) {
            return n;
        }
        
        if(word1.charAt(n - 1) == word2.charAt(m - 1)) {
            return minDistance(word1, word2, n - 1, m - 1);
        } else {
            int c1 = minDistance(word1, word2, n - 1, m);     //deletion
            int c2 = minDistance(word1, word2, n, m - 1);     //insertion 
            int c3 = minDistance(word1, word2, n - 1, m - 1); //replace
            
            return 1 + Math.min(c1, Math.min(c2, c3));
        }
    }
}

//Bottom Up
Time Complexity - O(n ^ 2)
Space Complexity - O(n ^ 2)
class Solution {
    public int minDistance(String word1, String word2) {
        
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        dp[0][0] = 0;
        
        for(int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        
        for(int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
    }
}
