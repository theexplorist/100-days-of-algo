import java.util.*;
public class Main {
    public static void main(String args[]) {
        int[][] dp = new int[4][4];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(numPalSubs("aaaa", 0, 3, dp));
    }

    public static int numPalSubs(String s, int si, int ei, int[][] dp) {
        if(si > ei) {
            return 0;
        }

        if(si == ei) {
            return 1;
        }

        if(dp[si][ei] != -1) {
            return dp[si][ei];
        }

        if(s.charAt(si) != s.charAt(ei)) {
            return dp[si][ei] = numPalSubs(s, si + 1, ei, dp) + numPalSubs(s, si, ei - 1, dp) - numPalSubs(s, si + 1, ei - 1, dp);
        } else {
            return dp[si][ei] = numPalSubs(s, si + 1, ei, dp) + numPalSubs(s, si, ei - 1, dp) + 1;
        }
    }
}
