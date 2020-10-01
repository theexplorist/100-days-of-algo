//Memoized Dp
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }
        
        int maxNum = Integer.MIN_VALUE;
        
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        int[] freq = new int[maxNum + 1];
        int[] dp = new int[maxNum + 2];
        Arrays.fill(dp, -1);
        for(int num : nums) {
            freq[num] += num;
        }
        
        for(int num : freq) {
            System.out.print(num + " ");
        }
         
        return deleteAndEarn(freq, 0, maxNum + 1, dp);
    }
    
    private int deleteAndEarn(int[] freq, int i, int n, int[] dp) {
        
        if(i >= n) {
            return 0;
            
        }
         
        if(dp[i] != -1) {
            return dp[i];
        }
        
        return dp[i] = Math.max(deleteAndEarn(freq, i + 1, n, dp), freq[i] + deleteAndEarn(freq, i + 2, n, dp));
    }
}

//Bottom Up Extra Space
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }
        
        int maxNum = Integer.MIN_VALUE;
        
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        int[] freq = new int[maxNum + 1];
        int[] dp = new int[maxNum + 2];
        Arrays.fill(dp, -1);
        for(int num : nums) {
            freq[num] += num;
        }
        
        dp[0] = 0;
        dp[1] = freq[0];
        
        for(int i = 2; i <= maxNum + 1; i++) {
            dp[i] = Math.max(dp[i - 1], freq[i - 1] + dp[i - 2]);
        }
        
        
         
        return dp[maxNum + 1];
    }
}

//Bottom Up Constant Space
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }
        
        int maxNum = Integer.MIN_VALUE;
        
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        int[] freq = new int[maxNum + 1];
        int[] dp = new int[maxNum + 2];
        Arrays.fill(dp, -1);
        for(int num : nums) {
            freq[num] += num;
        }
        
        int a = 0;
        int b = freq[0];
        
        int temp = 0;
        for(int i = 2; i <= maxNum + 1; i++) {
            temp = Math.max(b, freq[i - 1] + a);
            a = b;
            b = temp;
        }    
        return temp;
    }
}
