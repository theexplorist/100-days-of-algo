
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length;
        if(n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        
        if(m == 0) {
            return 0;
        }
        
        boolean[][] vis = new boolean[n][m];
        int[][] longestP = new int[n][m];
        
        int maxAns = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                
                int ans = DFS(matrix, i, j, -1, vis, longestP);
                if(ans > maxAns) {
                    maxAns = ans;
                }
            }
        }
        
        
        return maxAns;
    }
    
    private int DFS(int[][] matrix, int i, int j, int prev, boolean[][] visited, int[][] longestP) {
        
        if(i < 0 || i == matrix.length || j < 0 || j == matrix[0].length || visited[i][j] == true || prev >= matrix[i][j]) {
            return 0;
        }
        
        
        if(longestP[i][j] > 0) {
            return longestP[i][j];
        }
        
        visited[i][j] = true;
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                int top = 
            }
        }
        int top = DFS(matrix, i - 1, j, matrix[i][j], visited, longestP);
        int bottom = DFS(matrix, i + 1, j, matrix[i][j], visited, longestP);
        int right = DFS(matrix, i, j + 1, matrix[i][j], visited, longestP);
        int left = DFS(matrix, i, j - 1, matrix[i][j], visited, longestP);
        int path = 1 + Math.max(Math.max(top, bottom), Math.max(right, left));
        longestP[i][j] = path;
        visited[i][j] = false;
        return path;
    }
}
