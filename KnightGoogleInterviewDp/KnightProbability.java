//Recursive O(8 ^ n)
class Solution {
    
    int[] dirx = {1, -1, 1, -1, -2, -2, 2, 2};
    int[] diry = {2, 2, -2, -2, 1, -1, 1, -1};
    public double knightProbability(int N, int K, int r, int c) {
        if(r < 0 || c < 0 || r > N - 1 || c > N - 1) {
            return 0;
        }
        
        if(K == 0) {
            return 1;
        }
        
        double probab = 0;
        for(int i = 0; i < 8; i++) {
            probab += knightProbability(N, K - 1, r + dirx[i], c + diry[i]);
        }
        
        return probab * 0.125;
    }
}

//Dp O(n ^ 3)
class Solution {
    
    int[] dirx = {1, -1, 1, -1, -2, -2, 2, 2};
    int[] diry = {2, 2, -2, -2, 1, -1, 1, -1};
    public double knightProbability(int N, int K, int r, int c) {
        Map<String, Double> dp = new HashMap<>();
        
        return knightProbability(N, K, r, c, dp);
    }
    
    public String keyGenerator(int k, int r, int c) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(k);
        sb.append("|");
        sb.append(r);
        sb.append("|");
        sb.append(c);
        
        return sb.toString();
    }
    public double knightProbability(int N, int K, int r, int c, Map<String, Double> dp) {
        if(r < 0 || c < 0 || r > N - 1 || c > N - 1) {
            return 0;
        }
        
        if(K == 0) {
            return 1;
        }
        
        String key = keyGenerator(K, r, c);
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        
        
        double probab = 0;
        for(int i = 0; i < 8; i++) {
            probab += knightProbability(N, K - 1, r + dirx[i], c + diry[i], dp);
        }
        
        dp.put(key, probab * 0.125);
        return probab * 0.125;
    }
}
