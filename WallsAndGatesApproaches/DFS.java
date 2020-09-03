public class DFS {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    wallsAndGatesDfs(rooms, i, j, new int[rooms.length][rooms[0].length], 0);
                }
            }
        }
    }
    
    public void wallsAndGatesDfs(int[][] rooms, int sx, int sy, int vis[][], int dis) {
        
        if(sx < 0 || sy < 0 || sx >= rooms.length || sy >=rooms[0].length || vis[sx][sy] == 1) {
            return;
        }
        
        if(rooms[sx][sy] == -1) {
            return;
        }
        
        if(dis < rooms[sx][sy]) {
            rooms[sx][sy] = dis;
        }
        
        
        
        vis[sx][sy] = 1;
        wallsAndGatesDfs(rooms, sx, sy + 1, vis, dis + 1);
        wallsAndGatesDfs(rooms, sx + 1, sy, vis, dis + 1);
        wallsAndGatesDfs(rooms, sx - 1, sy, vis, dis + 1);
        wallsAndGatesDfs(rooms, sx, sy - 1, vis, dis + 1);
        vis[sx][sy] = 0;
    }
}
