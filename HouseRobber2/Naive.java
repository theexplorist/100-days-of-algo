class Naive {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        return rob(nums, 0, false);
    }
    
    public int rob(int[] nums, int i, boolean isTaken) {
        
        if(i >= nums.length) {
            return 0;
        }
        int a = 0;
        if(i == 0) {
            a = nums[i] + rob(nums, i + 2, true);
        } else if(i == nums.length - 1) {
            if(!isTaken)
            a = nums[i] + rob(nums, i + 2, isTaken);
        } else {
            a = nums[i] + rob(nums, i + 2, isTaken);
        }
        
        int b = rob(nums, i + 1, isTaken);
        return Math.max(a, b);
    }
}
