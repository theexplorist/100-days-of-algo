//Bottom Up
Time Complexity - O(n)
Space Complexity - O(n)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int[] cache = new int[n + 1];
        
        cache[0] = 0;
        cache[1] = nums[0];
        
        for(int i = 2; i <= n; i++) {
            cache[i] = Math.max(cache[i - 2] + nums[i - 1], cache[i - 1]);
        }
        
        return cache[n];
    }
}

//Space Optimised solution
Time Complexity - O(n)
Space Complexity - O(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int[] cache = new int[n + 1];
        
        int a = 0, b = nums[0];
        
        for(int i = 2; i <= n; i++) {
            int temp = Math.max(nums[i - 1] + a, b);
            a = b;
            b = temp;
        }
        
        return b;
    }
}
