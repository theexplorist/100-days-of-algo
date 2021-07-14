class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; ++i) {
            v[i] = sc.nextInt();
        }

        System.out.println(lengthOfLIS(v));
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lengthOfLIS(nums, 0, nums.length, -1, dp);
    }
    
    public int lengthOfLIS(int[] nums, int curr, int n, int pi, int[][] dp) {
        
        if(curr == n) {
            return 0;
        }
        
        if(dp[curr][pi + 1] != -1) {
            return dp[curr][pi + 1];
        }
        
        int c1 = 0, c2 = 0;
        if(pi == -1 || nums[curr] > nums[pi]) {
            c1 = 1 + lengthOfLIS(nums, curr + 1, n, curr, dp);
        }
        
        c2 = lengthOfLIS(nums, curr + 1, n, pi, dp);
        
        return dp[curr][pi + 1] = Math.max(c1, c2);
    }
}
