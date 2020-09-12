class BFSSol {
    static  int[] dx = {0, 0, -1, 1};
    static  int[] dy = {1, -1, 0, 0};
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    BFS(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private boolean isSafe(char[][] grid, int i, int j) {
        
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1';
    }
    private void BFS(char[][] grid, int i, int j) {
        Queue<int[]> bfs = new LinkedList<>();
        
        bfs.add(new int[]{i, j});
        grid[i][j] = '0';
        
        while(!bfs.isEmpty()) {
            int[] pair = bfs.poll();
            
            for(int k = 0; k < 4; k++) {
                int x = pair[0] + dx[k];
                int y = pair[1] + dy[k];
                
                if(isSafe(grid, x, y)) {
                    grid[x][y] = '0';
                    bfs.add(new int[]{x, y});
                }
            }
        }
    }
}
