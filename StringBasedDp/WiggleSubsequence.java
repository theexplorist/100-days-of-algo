//Time Complexity - O(2 ^ n)
class Solution {
    public int wiggleMaxLength(int[] nums) {
        return Math.max(wiggleHelper(nums, -1, 0, true), wiggleHelper(nums, -1, 0, false));
    }
    
    private int wiggleHelper(int[] nums, int pi, int ci, boolean isAsc) {
        
        if(ci >= nums.length) {
            return 0;
        }
        
        int c1 = 0;
        if(isAsc) {
            if(pi == -1 || nums[pi] < nums[ci]) {
                c1 = 1 + wiggleHelper(nums, ci, ci + 1, !isAsc);
            }
        } else {
            if(pi == -1 || nums[pi] > nums[ci]) {
                c1 = 1 + wiggleHelper(nums, ci, ci + 1, !isAsc);
            }
        }
        
        int c2 = wiggleHelper(nums, ci, ci + 1, isAsc);
        return Math.max(c1, c2);
    }
}

//Time Complexity - O(n ^ 2)
class Solution {
    boolean isAsc;
    public int wiggleMaxLeng+th(int[] nums) {
        Map<String, Integer> cache1 = new HashMap<>();
        Map<String, Integer> cache2 = new HashMap<>();
        return Math.max(wiggleHelper(nums, -1, 0, true, cache1), wiggleHelper(nums, -1, 0, false, cache2));
    }
    
    private int wiggleHelper(int[] nums, int pi, int ci, boolean isAsc, Map<String, Integer> cache) {
        
        if(ci >= nums.length) {
            return 0;
        }
        
        String key = pi + "|" + ci + "|" + isAsc;
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        
        int c1 = 0;
        if(isAsc) {
            if(pi == -1 || nums[pi] < nums[ci]) {
                c1 = 1 + wiggleHelper(nums, ci, ci + 1, !isAsc, cache);
            }
        } else {
            if(pi == -1 || nums[pi] > nums[ci]) {
                c1 = 1 + wiggleHelper(nums, ci, ci + 1, !isAsc, cache);
            }
        }
        
        int c2 = wiggleHelper(nums, ci, ci + 1, isAsc, cache);
        cache.put(key, Math.max(c1, c2));
        return Math.max(c1, c2);
    }
}
