class DFS {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    int recAns = maxAreaOfIsland(grid, i, j, n, m);
                    maxArea = Math.max(recAns, maxArea);
                } 
            }
        }
        
        return maxArea;
    }
    
    private int maxAreaOfIsland(int[][] grid, int i, int j, int n, int m) {
        
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return 0;
        }
        
        grid[i][j] = 0;
        int a1 = maxAreaOfIsland(grid, i + 1, j, n, m);
        int a2 = maxAreaOfIsland(grid, i - 1, j, n, m);
        int a3 = maxAreaOfIsland(grid, i, j - 1, n, m);
        int a4 = maxAreaOfIsland(grid, i, j + 1, n, m);

        return 1 + a1 + a2 + a3 + a4;
    }
}
