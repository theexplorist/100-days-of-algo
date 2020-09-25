class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] cache = new int[n + 1][m + 1];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return maxDotProduct(nums1, nums2, n, m, cache);
    }
    
    private int maxDotProduct(int[] nums1, int[] nums2, int n, int m, int[][] cache) {
        
        if(n == 0 || m == 0) {
            return -10000000;
        }
        
        if(cache[n][m] != -1) {
            return cache[n][m];
        }
        
        int c1 = nums1[n - 1] * nums2[m - 1] + maxDotProduct(nums1, nums2, n - 1, m - 1, cache);
        int c2 = maxDotProduct(nums1, nums2, n - 1, m, cache);
        int c3= maxDotProduct(nums1, nums2, n, m - 1, cache);
        
        return cache[n][m] = Math.max(Math.max(nums1[n - 1] * nums2[m - 1], c1), Math.max(c2, c3));
    }
}
