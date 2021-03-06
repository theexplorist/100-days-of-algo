class Floodfill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int color = image[sr][sc ];
        
        if(color == newColor) {
            return image;
        }
        
        int n = image.length;
        int m = image[0].length;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<int[]> bfs = new LinkedList<>();
        
        bfs.add(new int[]{sr, sc});
        image[sr][sc] = newColor;
        
        while(!bfs.isEmpty()) {
            int[] pair = bfs.poll();
            
            for(int k = 0; k < 4; k++) {
                int x = pair[0] + dx[k];
                int y = pair[1] + dy[k];
                
                if(x >= 0 && y >= 0 && x < n && y < m && image[x][y] == color) {
                    image[x][y] = newColor;
                    bfs.add(new int[]{x, y});
                }
            }
        }
        
        return image;
    }
}
