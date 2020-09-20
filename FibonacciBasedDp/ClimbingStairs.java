

//Bottom Up
Time Complexity - O(n)
Space Complexity - O(n)
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];   
    }
}

//Space Optimized
Time Complexity - O(n)
Space Complexity - O(1)
class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        
        for(int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        
        return b;
    }
}
