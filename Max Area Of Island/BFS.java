class BFS {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        int maxAns = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    maxAns = Math.max(maxAns, bfs(grid, i, j));    
                }
            }
        }
        return maxAns;
    }
    
    public boolean isSafe(int[][] grid, int i, int j) {
        
        int n = grid.length, m = grid[0].length;
        return i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == 1;
    }
    
    public int bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = 0;
        int area = 0;
        while(!q.isEmpty()) {
            int[] pair = q.poll();
            area++;
            
            for(int k = 0; k < 4; k++) {
                int x = pair[0] + dx[k];
                int y = pair[1] + dy[k];
                
                if(isSafe(grid, x, y)) {
                    q.add(new int[]{x, y});
                    grid[x][y] = 0;
                }
            }
        }
        return area;
    }
}
