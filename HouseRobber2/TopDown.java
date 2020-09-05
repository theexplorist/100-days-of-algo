class TopDown {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int[][] dp = new int[2][nums.length + 1];
        for(int[] row : dp)
        Arrays.fill(row, - 1);
        return rob(nums, 0, 0, dp);
    }
    
    public int rob(int[] nums, int i, int isTaken, int[][] dp) {
        
        if(i >= nums.length) {
            return 0;
        }
        
        if(dp[isTaken][i] != -1) {
            return dp[isTaken][i];
        }
        int a = 0;
        if(i == 0) {
            a = nums[i] + rob(nums, i + 2, 1, dp);
        } else if(i == nums.length - 1) {
            if(isTaken == 0)
            a = nums[i] + rob(nums, i + 2, isTaken, dp);
        } else {
            a = nums[i] + rob(nums, i + 2, isTaken, dp);
        }
        
        int b = rob(nums, i + 1, isTaken, dp);
        return dp[isTaken][i] = Math.max(a, b);
    }
}
