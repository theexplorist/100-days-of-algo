class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int closedCount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    if(bFS(i, j, grid)) {
                        closedCount++;   
                    }  
                }
            }
        }
        
        return closedCount;
    }
    
    public boolean bFS(int i, int j, int[][] grid) {
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{i, j});
        grid[i][j] = 1;
        
        boolean isClosed = true;
        while(!bfs.isEmpty()) {
            int[] pair = bfs.poll();
            
            for(int k = 0; k < 4; k++) {
                int x = pair[0] + dx[k];
                int y = pair[1] + dy[k];
                
                if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                    if(grid[x][y] == 0) {
                        grid[x][y] = 1;
                        bfs.add(new int[]{x, y});   
                    }
                } else {
                    isClosed = false;
                }
            }            
        }
        return isClosed;
    }
}
