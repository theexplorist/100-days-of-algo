//Time Complexity - O(2 ^ n)
//Space Complexity - O(n + m)
class Solution {
    public int findLength(int[] A, int[] B) {
        return findLength(A, B, A.length, B.length);
    }
    
    private int findLength(int[] A, int[] B, int n, int m) {
        
        
        if(n == 0 || m == 0) {
            return 0;
        }
        
        int c1 = 0, c2 = 0, c3 = 0;
        if(A[n - 1] == B[m - 1]) {
            c1 = findLength(A, B, n - 1, m - 1) + 1;
        } else {
            c2 = findLength(A, B, n - 1, m);
            c3 = findLength(A, B, n, m - 1);
        }
        
        return Math.max(c1, Math.max(c2, c3));
    }
}
