//Top Down
Time Complexity - O(n)
Space Complexity - O(n)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(minCost(cost, n, dp), minCost(cost, n - 1, dp));
    }
    
    private int minCost(int[] cost, int n, int[] dp) {
        
        if(n == 1 || n == 2) {
            return cost[n - 1];
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        
        int c1 = minCost(cost, n - 1, dp);
        int c2 = minCost(cost, n - 2, dp);
        return dp[n] = cost[n - 1] + Math.min(c1, c2);
    }
}

//Bottom Up
Time Complexity - O(n)
Space Complexity - O(n)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.min(minCost(cost, n, dp1), minCost(cost, n - 1, dp2));
    }
    
    private int minCost(int[] cost, int n, int[] dp) {
        
        if(n == 1 || n == 2) {
            dp[n] = cost[n - 1];
        }
        
        dp[1] = cost[0];
        dp[2] = cost[1];
        
        for(int i = 3; i <= n; i++) {
            dp[i] = cost[i - 1] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        return dp[n];
    }
}

//Space Optimsed
Time Complexity - O(n)
Space Complexity - O(1)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(cost, n), minCost(cost, n - 1));
    }
    
    private int minCost(int[] cost, int n) {
        
        
        int a = cost[0];
        int b = cost[1];
        
        for(int i = 3; i <= n; i++) {
            int temp = cost[i - 1] + Math.min(a, b);
            a = b;
            b = temp;
        }
        
        return b;
    }
}
