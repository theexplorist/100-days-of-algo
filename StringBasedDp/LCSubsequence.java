//Recursive
Time Complexity - O(2 ^ n)
Space Complexity - O(n + m)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        return lCS(text1, text2, text1.length(), text2.length());
    }
    
    private int lCS(String s1, String s2, int n, int m) {
        
        if(n == 0 || m == 0) {
            return 0;
        }
        
        
        int c1 = 0;
        int c2 = 0;
        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lCS(s1, s2, n - 1, m - 1);
        } else {
            c1 = lCS(s1, s2, n - 1, m);
            c2 = lCS(s1, s2, n, m - 1);
            return Math.max(c1, c2);
        }
    }
}

//Bottom Up
Time Complexity - O(n ^ 2)
Space Complexity - O(n ^ 2)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] cache = new int[text1.length() + 1][text2.length() + 1];
        for(int[] row : cache)
        Arrays.fill(row, -1);
        
        cache[0][0] = 0;
        
        for(int i = 0; i <= text1.length(); i++) {
            cache[i][0] = 0;
        }
        
        for(int j = 0; j <= text2.length(); j++) {
            cache[0][j] = 0;
        }
        
        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                } else {
                    int c1 = cache[i - 1][j];
                    int c2 = cache[i][j - 1];
                    
                    cache[i][j] = Math.max(c1, c2);
                }
            }
        }
        return cache[text1.length()][text2.length()];
    }
}
