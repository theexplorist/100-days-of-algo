//Recursive Time Complexity - O(2 ^ n)
//Run time - 25 ms

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        int totalSum = 0;
        
        for(int num : nums) {
            totalSum += num;
        }
        
        int winP = winnings(nums, 0, nums.length - 1);
        
        if(totalSum - winP <= winP) {
            return true;
        } else {
            return false;
        }
    }
    
    private int winnings(int[] nums, int i, int j) {
        
        if(i == j) {
            return nums[i];
        }
        
        if(j == i + 1) {
            return Math.max(nums[i], nums[j]);
        }
        
        int c1 = nums[i] + Math.min(winnings(nums, i + 1, j - 1), winnings(nums, i + 2, j));
        int c2 = nums[j] + Math.min(winnings(nums, i, j - 2), winnings(nums, i + 1, j - 1));
        
        return Math.max(c1, c2);
    }
}

//Top Down/Caching Dp Time Complexity - O(n ^ 2)
//Runtime - 0ms
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        int totalSum = 0;
        
        for(int num : nums) {
            totalSum += num;
        }
        
        int[][] dp = new int[nums.length][nums.length];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int winP = winnings(nums, 0, nums.length - 1, dp);
        
        if(totalSum - winP <= winP) {
            return true;
        } else {
            return false;
        }
    }
    
    private int winnings(int[] nums, int i, int j, int[][] dp) {
        
        if(i == j) {
            return nums[i];
        }
        
        if(j == i + 1) {
            return Math.max(nums[i], nums[j]);
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int c1 = nums[i] + Math.min(winnings(nums, i + 1, j - 1, dp), winnings(nums, i + 2, j, dp));
        int c2 = nums[j] + Math.min(winnings(nums, i, j - 2, dp), winnings(nums, i + 1, j - 1, dp));
        
        return dp[i][j] = Math.max(c1, c2);
    }
}
