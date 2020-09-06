class NaiveCached {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        
        for(int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));
        int[] dp = new int[startTime.length + 1];
        Arrays.fill(dp, -1);
        return maxProfit(jobs, 0, startTime.length, dp);
        
    }
    
    public int maxProfit(int[][] jobs, int curr, int n, int[] dp) {
        
        if(curr == n) {
            return 0;
        }
        
        if(dp[curr] != -1) {
            return dp[curr];
        }
        int c1 = maxProfit(jobs, curr + 1, n, dp);
        int c2 = jobs[curr][2];
        
        for(int i = curr + 1; i < n; i++) {
            if(jobs[curr][1] <= jobs[i][0]) {
                c2 += maxProfit(jobs, i, n, dp);
                break;
            }
        }
        
        return dp[curr] = Math.max(c1, c2);
    }
}
