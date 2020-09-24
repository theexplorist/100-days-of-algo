import java.util.*;
class Main {
    public static int lengthOfLIS(int[] nums) {
       // Map<String, Integer> cache = new HashMap<>();
        int[][] cache = new int[nums.length + 1][nums.length + 1];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return lengthOfLIS(nums, nums.length - 1, -1, cache);
    }
    
    private static int lengthOfLIS(int[] nums, int ci, int pi, int[][] cache) {
        
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

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0};
        //Subtract the length of LIS from array length, those are the minimum deletions to make sequence sorted
        System.out.println(arr.length - lengthOfLIS(arr));
    }
}
