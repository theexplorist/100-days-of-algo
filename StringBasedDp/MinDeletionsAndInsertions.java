//Time Complexity - O(n ^ 2)
import java.util.*;
class Main {
    public static int longestCommonSubsequence(String text1, String text2) {
        
        int[][] cache = new int[text1.length() + 1][text2.length() + 1];
        for(int[] row : cache)
        Arrays.fill(row, -1);
        
        cache[0][0] = 0;
        
        for(int i = 0; i <= text1.length(); i++) {
            cache[i][0] = 0;
        }
        
        for(int j = 0; j <= text2.length(); j++) {
            cache[0][j] = 0;
        }
        
        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                } else {
                    int c1 = cache[i - 1][j];
                    int c2 = cache[i][j - 1];
                    
                    cache[i][j] = Math.max(c1, c2);
                }
            }
        }
        return cache[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        int lcsLength = longestCommonSubsequence("passport", "ppsspt");

        System.out.println((8 - lcsLength) + " deletions and " + (6 - lcsLength) + " insertions ");
    }
}
