//Recursive
Time Complexity - O(2 ^ n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, nums.length - 1, -1);
    }
    
    private int lengthOfLIS(int[] nums, int ci, int pi) {
        
        if(ci < 0) {
            return 0;
        }
        
        int c1 = 0;
        if(pi == -1 || nums[ci] < nums[pi]) {
            c1 = 1 + lengthOfLIS(nums, ci - 1, ci);
        }
        
        int c2 = lengthOfLIS(nums, ci - 1, pi);
        return Math.max(c1, c2);
    }
}

//Top Down
Time Complexity - O(n ^ 2)
class Solution {
    public int lengthOfLIS(int[] nums) {
       // Map<String, Integer> cache = new HashMap<>();
        int[][] cache = new int[nums.length + 1][nums.length + 1];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return lengthOfLIS(nums, nums.length - 1, -1, cache);
    }
    
    private int lengthOfLIS(int[] nums, int ci, int pi, int[][] cache) {
        
        if(ci < 0) {
            return 0;
        }
        
        if(cache[ci][pi + 1] != -1) {
            return cache[ci][pi + 1];
        }
        
        int c1 = 0;
        if(pi == -1 || nums[ci] < nums[pi]) {
            c1 = 1 + lengthOfLIS(nums, ci - 1, ci, cache);
        }
        
        int c2 = lengthOfLIS(nums, ci - 1, pi, cache);
        return cache[ci][pi + 1] = Math.max(c1, c2);
    }
}
