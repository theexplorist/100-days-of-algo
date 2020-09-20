import java.util.*;
public class Main {

   //Recursive
   Time Complexity - O(3 ^ n)
   
    public static int sumFact(int n) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        int c1 = sumFact(n - 1);
        int c2 = sumFact(n - 3);
        int c3 = sumFact(n - 4);

        return c1 + c2 + c3;
    }
    
    //Top Down
    Time Complexity - O(n)
    Space Complexity - O(n)
    public static int sumFactCached(int n, int[] dp) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int c1 = sumFact(n - 1);
        int c2 = sumFact(n - 3);
        int c3 = sumFact(n - 4);

        return dp[n] = c1 + c2 + c3;
    }
    
    //Bottom Up
    Time Complexity - O(n)
    Space Complexity - O(n)
    public static int sumFactBu(int n, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for(int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }

        return dp[n];
    }
    public static void main(String args[]) {
        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        System.out.println(sumFactBu(10, dp));
    }
}
