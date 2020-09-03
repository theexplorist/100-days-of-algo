public class MutliEndBfs {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
     
    public static int dx[] = {0, 0, 1, -1};
    public static int dy[] = {1, -1, 0, 0};
    public static int INF = 2147483647;
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        Queue<int[]> bfs = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0)
                bfs.add(new int[]{i, j});
            }
        }
        
        wallsAndGatesBfs(rooms, bfs);
    }
    
    public void wallsAndGatesBfs(int[][] rooms, Queue<int[]> bfs) {
        while(!bfs.isEmpty()) {
            int[] disArr = bfs.remove();
            int disx = disArr[0];
            int disy = disArr[1];
            
            for(int k = 0; k < 4; k++) {
                int x = disx + dx[k];
                int y = disy + dy[k];
                
                if(x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length && rooms[x][y] == INF) {
                    bfs.add(new int[]{x, y});
                    rooms[x][y] = rooms[disx][disy] + 1;
                }
            }
        }
        
    }
}
